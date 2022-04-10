package ru.job4j.ood.ocp;

import org.junit.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import javax.xml.bind.JAXBException;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class XMLConverterTest {

    @Test
    public void whenConvertToXML() throws JAXBException {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan", null, null, 100);
        Employee worker2 = new Employee("Boris", null, null, 120);
        store.add(worker1);
        store.add(worker2);
        Converter converter = new XMLConverter();
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employees>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100</salary>\n")
                .append("    </employees>\n")
                .append("    <employees>\n")
                .append("        <name>Boris</name>\n")
                .append("        <salary>120</salary>\n")
                .append("    </employees>\n")
                .append("</employees>\n");
        assertThat(converter.convert(store), is(expect.toString()));
    }
}