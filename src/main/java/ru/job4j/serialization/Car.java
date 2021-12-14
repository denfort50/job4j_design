package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "Car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private String model;
    @XmlAttribute
    private boolean sportCar;
    @XmlAttribute
    private int year;
    private Engine engine;
    @XmlElementWrapper(name = "proses")
    @XmlElement(name = "pros")
    private String[] pros;

    public Car() {
    }

    public Car(String model, boolean sportCar, int year, Engine engine, String[] pros) {
        this.model = model;
        this.sportCar = sportCar;
        this.year = year;
        this.engine = engine;
        this.pros = pros;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", sportCar=" + sportCar
                + ", volume=" + year
                + ", engine=" + engine
                + ", pros=" + Arrays.toString(pros)
                + '}';
    }

    public String getModel() {
        return model;
    }

    public boolean isSportCar() {
        return sportCar;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    public String[] getPros() {
        return pros;
    }

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car("Nissan GT-R", true, 2019,
                new Engine("VR38DETT", 3.8, 540),
                new String[] {"extreme", "design"});

        JSONObject jsonEngine = new JSONObject();
        jsonEngine.put("name", car.getEngine().getName());
        jsonEngine.put("volume", car.getEngine().getVolume());
        jsonEngine.put("horsePowers", car.getEngine().getHorsePowers());

        List<String> list = new ArrayList<>();
        list.add(car.getEngine().getName());
        list.add(String.valueOf(car.getEngine().getVolume()));
        list.add(String.valueOf(car.getEngine().getHorsePowers()));
        JSONArray jsonProses = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model", car.getModel());
        jsonObject.put("sportCar", car.isSportCar());
        jsonObject.put("year", car.getYear());
        jsonObject.put("Engine", jsonEngine);
        jsonObject.put("proses", jsonProses);

        System.out.println("JSONObject:" + System.lineSeparator() + jsonObject.toString() + System.lineSeparator());
        System.out.println("String:" + System.lineSeparator() + new JSONObject(car).toString());
    }
}
