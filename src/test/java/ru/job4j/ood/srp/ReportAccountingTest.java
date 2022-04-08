package ru.job4j.ood.srp;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import java.util.Calendar;

public class ReportAccountingTest {

    @Test
    public void whenAccountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Boris", now, now, 120);
        Employee worker3 = new Employee("Alex", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;\n")
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary() * ReportAccounting.TO_USD).append(" USD;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary() * ReportAccounting.TO_USD).append(" USD;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getHired()).append(";")
                .append(worker3.getFired()).append(";")
                .append(worker3.getSalary() * ReportAccounting.TO_USD).append(" USD;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
