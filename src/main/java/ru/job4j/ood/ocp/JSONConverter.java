package ru.job4j.ood.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.Store;

import java.util.List;

public class JSONConverter implements Converter {
    @Override
    public String convert(Store store) {
        List<Employee> employeeList = store.findBy(employee -> true);
        Gson lib = new GsonBuilder().create();
        return lib.toJson(employeeList);
    }
}
