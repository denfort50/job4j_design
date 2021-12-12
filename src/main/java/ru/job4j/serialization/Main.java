package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car("Toyota Camry", false, 2018,
                new Engine("2GR-FE", 3.5, 277),
                new String[]{"reliability", "speed"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carGson =
                "{"
                        + "\"model\":\"Toyota Camry\","
                        + "\"sportCar\":true,"
                        + "\"year\":2018,"
                        + "\"engine\":"
                        + "{"
                        + "\"name\":\"2GR-FE\","
                        + "\"volume\":3.5,"
                        + "\"horsePowers\":350"
                        + "},"
                        + "\"pros\":"
                        + "[\"prestige\",\"superSpeed\"]"
                        + "}";
        final Car carMod = gson.fromJson(carGson, Car.class);
        System.out.println(carMod);
    }
}
