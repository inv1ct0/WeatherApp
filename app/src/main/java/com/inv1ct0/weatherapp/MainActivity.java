package com.inv1ct0.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView temperatureNow, humidityNow, overcastNow;
    private CheckBox humidity, overcast;
    private final String temperatureKey = "temperatureKey";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                ImageView imageView = findViewById(R.id.imageView);
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.moscow);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.spetersburg);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.ekaterinburg);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        humidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(humidity.isChecked()) {
                    humidityNow.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Show humidity", Toast.LENGTH_SHORT).show();
                } else {
                    humidityNow.setVisibility(View.INVISIBLE);
                }
            }
        });
        overcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(overcast.isChecked()) {
                    overcastNow.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Show overcoast", Toast.LENGTH_SHORT).show();
                } else {
                    overcastNow.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void initViews() {
        temperatureNow = findViewById(R.id.temperatureNow);
        humidity = findViewById(R.id.humidity);
        overcast = findViewById(R.id.overcast);
        humidityNow = findViewById(R.id.humidityNow);
        humidityNow.setVisibility(View.INVISIBLE);
        overcastNow = findViewById(R.id.overcastNow);
        overcastNow.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        String temperature = temperatureNow.getText().toString();
        saveInstanceState.putString(temperatureKey, temperature);
        super.onSaveInstanceState(saveInstanceState);

        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String temperature = temperatureNow.getText().toString();
        savedInstanceState.getString(temperatureKey, temperature);
        temperatureNow.setText(temperature);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }
}