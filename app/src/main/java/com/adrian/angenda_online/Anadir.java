package com.adrian.angenda_online;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Calendar;

public class Anadir extends AppCompatActivity {

    private EditText editTextDate;
    private Switch notificationSwitch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);

        editTextDate = findViewById(R.id.editTextDate5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView imageViewCalendar = findViewById(R.id.imageCalendar);
        notificationSwitch = findViewById(R.id.notificationSwitch);

        imageViewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // El interruptor está activado, habilitar las notificaciones
                    showNotification();
                } else {
                    // El interruptor está desactivado, deshabilitar las notificaciones
                    cancelNotification();
                }
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Anadir.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    // Se ejecuta cuando se selecciona una fecha
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editTextDate.setText(selectedDate);
                }, year, month, day);

        datePickerDialog.show();
    }

    private void showNotification() {
        Notification.Builder builder = new Notification.Builder(Anadir.this);
        builder.setContentTitle("Recordatorio de tarea");
        builder.setContentText("¡Tienes una tarea pendiente!");
        builder.setSmallIcon(R.drawable.notificacion);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "my_channel_id";
            CharSequence channelName = "My Channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.notify(1, builder.build());
    }

    private void cancelNotification() {
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.cancel(1);
    }
}
