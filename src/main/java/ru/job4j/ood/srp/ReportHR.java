package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        list.sort((o1, o2) -> o2.getSalary() - o1.getSalary());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;\n");
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
