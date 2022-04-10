package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Store;

import javax.xml.bind.JAXBException;

public interface Converter {
    public String convert(Store store) throws JAXBException;
}
