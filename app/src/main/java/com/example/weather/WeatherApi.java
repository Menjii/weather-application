package com.example.weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather?APPID=749561a315b14523a8f5f1ef95e45864&units=metric")
    Call<Example> getWeather(@Query("q") String name);

}
