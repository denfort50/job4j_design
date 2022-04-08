package ru.job4j.ood.srp;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportIT implements Report {
    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<title>ITReport</title>\n")
                .append("<body>\n")
                .append("Name; Hired; Fired; Salary;\n");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>\n")
                .append("</html>");
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Boris", now, now, 120);
        Employee worker3 = new Employee("Alex", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportIT(store);
        String result = engine.generate(employee -> true);
        System.out.println(result);
    }
}
