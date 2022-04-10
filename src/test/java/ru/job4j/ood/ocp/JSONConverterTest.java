package ru.job4j.ood.ocp;

import org.junit.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import javax.xml.bind.JAXBException;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class JSONConverterTest {

    @Test
    public void whenConvertToJSON() throws JAXBException {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan", null, null, 100);
        Employee worker2 = new Employee("Boris", null, null, 120);
        store.add(worker1);
        store.add(worker2);
        Converter converter = new JSONConverter();
        String expect = "[{\"name\":\"Ivan\",\"salary\":100},{\"name\":\"Boris\",\"salary\":120}]";
        assertThat(converter.convert(store), is(expect));
    }

}