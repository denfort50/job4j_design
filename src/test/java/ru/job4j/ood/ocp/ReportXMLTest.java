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

public class ReportXMLTest {

    @Test
    public void whenGenerateReportInXML() {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 12);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String dateString = formatter.format(date.getTime());
        Employee worker1 = new Employee("Ivan", date, date, 100);
        Employee worker2 = new Employee("Boris", date, date, 120);
        store.add(worker1);
        store.add(worker2);
        Report report = new ReportXML(store);
        String employeeXmlTemplate =
                "<employee><fired>%s</fired><hired>%s</hired><name>%s</name><salary>%d</salary></employee>";
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>")
                .append(String.format(Locale.US, employeeXmlTemplate,
                        dateString, dateString, worker1.getName(), worker1.getSalary()))
                .append(String.format(Locale.US, employeeXmlTemplate,
                        dateString, dateString, worker2.getName(), worker2.getSalary()))
                .append("</employees>");
        String result = report.generate(em -> true).replaceAll("\\n\\s*", "");
        assertThat(result, is(expect.toString()));
    }
}
