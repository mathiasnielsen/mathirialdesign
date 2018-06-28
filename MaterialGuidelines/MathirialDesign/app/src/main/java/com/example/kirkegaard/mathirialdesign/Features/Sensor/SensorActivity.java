package com.example.kirkegaard.mathirialdesign.Features.Sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kirkegaard.mathirialdesign.R;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private final float ALPHA = 0.50f;

    private SensorManager sensorManager;

    private float[] gravity = new float[3];
    private float[] magnitude = new float[3];
    private float[] accelleration = new float[3];
    private float[] gyroscope = new float[3];

    private TextView textViewSensorType;
    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        textViewSensorType = (TextView)findViewById(R.id.SensorTextViewValueType);
        textViewX = (TextView)findViewById(R.id.SensorTextViewValueX);
        textViewY = (TextView)findViewById(R.id.SensorTextViewValueY);
        textViewZ = (TextView)findViewById(R.id.SensorTextViewValueZ);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //RegisterSensorType(Sensor.TYPE_GRAVITY, "Gravity");
        RegisterSensorType(Sensor.TYPE_GYROSCOPE, "GyroScope");
    }

    private void RegisterSensorType(int sensorType, String typeText)
    {
        textViewSensorType.setText(typeText);
        sensorManager.registerListener(
                this,
                sensorManager.getDefaultSensor(sensorType),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        float[] valuesAsArray = event.values;
        float[] valuesToUse = valuesAsArray;

        switch (event.sensor.getType())
        {
            case Sensor.TYPE_GRAVITY:
                valuesToUse = SetValues(event.values, gravity);
                break;

            case Sensor.TYPE_ACCELEROMETER:
                valuesToUse = SetValues(event.values, accelleration);
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                valuesToUse = SetValues(event.values, magnitude);
                break;

            case Sensor.TYPE_GYROSCOPE:
                valuesToUse = SetValues(event.values, gyroscope);
                break;
        }

        textViewX.setText("X: " + valuesToUse[0]);
        textViewY.setText("Y: " + valuesToUse[1]);
        textViewZ.setText("Z: " + valuesToUse[2]);
    }

    private float[] SetValues(float[] rawValues, float[] oldValues)
    {
        float[] filteredValues = LowPass(rawValues, oldValues);
        oldValues[0] = filteredValues[0];
        oldValues[1] = filteredValues[1];
        oldValues[2] = filteredValues[2];

        return filteredValues;
    }

    @Override
    public void onAccuracyChanged(
            Sensor sensor,
            int accuracy) {
    }

    /// <summary>
    /// https://www.built.io/blog/applying-low-pass-filter-to-android-sensor-s-readings#sthash.Ai9FuXRB.dpuf
    /// </summary>
    /// <param name="input"></param>
    /// <param name="output"></param>
    /// <returns></returns>
    protected float[] LowPass(float[] input, float[] output)
    {
        if (output == null)
        {
            return input;
        }

        for (int i = 0; i < input.length; i++)
        {
            output[i] = output[i] + ALPHA * (input[i] - output[i]);
        }

        return output;
    }
}
