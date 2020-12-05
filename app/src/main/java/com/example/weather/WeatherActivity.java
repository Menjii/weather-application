package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {
    TextView cityStringName, cityStringTime, cityStringTemp, cityStringPressure, cityStringHumidity, cityStringMinTemp, cityStringMaxTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityStringName = findViewById(R.id.id_cityName);
        cityStringTime = findViewById(R.id.id_cityTime);
        cityStringTemp = findViewById(R.id.id_tempValue);
        cityStringPressure = findViewById(R.id.id_pressureValue);
        cityStringHumidity = findViewById(R.id.id_humidityValue);
        cityStringMinTemp = findViewById(R.id.id_tempMinValue);
        cityStringMaxTemp = findViewById(R.id.id_tempMaxValue);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String cityName = extras.getString("cityName");
            getWeatherData(cityName.trim());
        }

    }

    private void getWeatherData(String name) {

        WeatherApi weatherApi = ApiClient.getClient().create(WeatherApi.class);

        Call<Example> call = weatherApi.getWeather(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                /*if (!response.isSuccessful()) {
                    Log.d("DATA: ", response.body().getPost().getTemp());
                    return;
                }*/
                try {
                    cityStringName.setText(getIntent().getStringExtra("cityName"));
                    cityStringTemp.setText(response.body().getMain().getTemp());
                    cityStringPressure.setText(response.body().getMain().getPressure());
                    cityStringHumidity.setText(response.body().getMain().getHumidity());
                    cityStringMinTemp.setText(response.body().getMain().getTemp_min());
                    cityStringMaxTemp.setText(response.body().getMain().getTemp_max());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}