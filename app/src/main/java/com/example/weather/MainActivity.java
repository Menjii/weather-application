package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button checkWeatherButton;
    EditText editText;
    public static String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkWeatherButton = findViewById(R.id.id_weatherButton);
        editText = findViewById(R.id.id_editText);
        cityName = editText.getText().toString().trim();

        checkWeatherButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openWeatherActivity();
            }
        });

    }

   /* protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("cityName", cityName);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cityName = savedInstanceState.getString("cityName");
    }
    */

    protected void openWeatherActivity() {
        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra("cityName", cityName);
        startActivity(intent);
    }
}