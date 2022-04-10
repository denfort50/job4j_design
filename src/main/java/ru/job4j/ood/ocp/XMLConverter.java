package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class XMLConverter implements Converter {
    @Override
    public String convert(Store store) throws JAXBException {
        List<Employee> employeeList = store.findBy(employee -> true);
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        StringWriter writer = new StringWriter();
        marshaller.marshal(new Employees(employeeList), writer);
        xml = writer.getBuffer().toString();
        return xml;
    }
}
