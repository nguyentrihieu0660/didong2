package com.example.nhomba.GiaoDien;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhomba.R;

public class MainSensor extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    long tgianTruoc;
    int i = 1;
    ImageView imgHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        setControl();
        setEvent();
    }

    private void setControl() {
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
    }

    private void setEvent() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            // doi hinh
            layVecTorvathaydoitext(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void layVecTorvathaydoitext(SensorEvent event){
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float vector = ( x*x + y*y + z*z )/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        if (vector >= 2){
            long tgSau = event.timestamp;
            if((tgSau - tgianTruoc) > 400){
                i++;

                if(i == 3 ){
                    imgHinh.setImageResource(R.drawable.hinh3);

                }
                if(i == 4 ){
                    imgHinh.setImageResource(R.drawable.hinh1);

                }
                if(i == 5 ){
                    imgHinh.setImageResource(R.drawable.hinh4);

                }
                if(i == 6 ){
                    imgHinh.setImageResource(R.drawable.hinh5);
                    i = 1;

                }

            }
            tgianTruoc = tgSau;
        }
    }
}

