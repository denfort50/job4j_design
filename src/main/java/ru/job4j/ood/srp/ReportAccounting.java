package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportAccounting implements Report {
    private Store store;

    public ReportAccounting(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;\n");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * 1000 / 80).append(" USD;")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
