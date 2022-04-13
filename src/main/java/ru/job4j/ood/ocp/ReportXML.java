package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees();
        employees.setEmployees(store.findBy(filter));
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 12);
        Employee worker1 = new Employee("Ivan", date, date, 100);
        Employee worker2 = new Employee("Boris", date, date, 120);
        store.add(worker1);
        store.add(worker2);
        Report report = new ReportXML(store);
        System.out.println(report.generate(employee -> true));
    }
}
