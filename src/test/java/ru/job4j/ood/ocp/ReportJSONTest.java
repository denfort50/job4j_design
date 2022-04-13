package ru.job4j.ood.ocp;

import org.junit.Test;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Employee;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ReportJSONTest {

    @Test
    public void whenGenerateReportInJSON() {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 12);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String dateString = formatter.format(date.getTime());
        Employee worker1 = new Employee("Ivan", date, date, 100);
        Employee worker2 = new Employee("Boris", date, date, 120);
        store.add(worker1);
        store.add(worker2);
        Report report = new ReportJSON(store);
        String employeeJsonTemplate =
                "{\"name\":\"%s\",\"hired\":\"%s\",\"fired\":\"%s\",\"salary\":%d}";
        StringBuilder expect = new StringBuilder()
                .append("{\"employees\":[")
                .append(String.format(Locale.US, employeeJsonTemplate + ",",
                        worker1.getName(), dateString, dateString, worker1.getSalary()))
                .append(String.format(Locale.US, employeeJsonTemplate,
                        worker2.getName(), dateString, dateString, worker2.getSalary()))
                .append("]}");
        String result = report.generate(employee -> true);
        assertThat(result, is(expect.toString()));
    }
}
