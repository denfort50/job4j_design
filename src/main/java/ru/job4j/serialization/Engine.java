package ru.job4j.serialization;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Engine")
public class Engine {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private double volume;
    @XmlAttribute
    private int horsePowers;

    public Engine() {
    }

    public Engine(String name, double volume, int horsePowers) {
        this.name = name;
        this.volume = volume;
        this.horsePowers = horsePowers;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "name='" + name + '\''
                + ", volume=" + volume
                + ", horsePowers=" + horsePowers
                + '}';
    }
}
