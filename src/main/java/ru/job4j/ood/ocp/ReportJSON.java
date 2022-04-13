package ru.job4j.ood.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees();
        employees.setEmployees(store.findBy(filter));
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJSON());
        Gson lib = builder.create();
        return lib.toJson(employees);
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 12);
        Employee worker1 = new Employee("Ivan", date, date, 100);
        Employee worker2 = new Employee("Boris", date, date, 120);
        store.add(worker1);
        store.add(worker2);
        Report report = new ReportJSON(store);
        System.out.println(report.generate(employee -> true));
    }
}
