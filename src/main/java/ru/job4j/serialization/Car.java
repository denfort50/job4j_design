package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

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

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car("Nissan GT-R", true, 2019,
                new Engine("VR38DETT", 3.8, 540),
                new String[] {"extreme", "design"});

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
