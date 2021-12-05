package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Files;

public class CSVReaderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void whenFilterTwoColumns() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out="
                + target.getAbsolutePath(), "-filter=name,age"
        });
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name;age",
                "Tom;20",
                "Jack;25",
                "William;30"
        ).concat(System.lineSeparator());
        CSVReader.handle(argsName);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }

    @Test
    public void whenFilterThreeColumns() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "firstName;lastName;age;sex;birthDate;job",
                "Keanu;Reeves;57;male;02.09.1964;actor",
                "Angelina;Jolie;46;female;04.06.1975;actress",
                "James;Cameron;67;male;16.08.1954;director",
                "Jerry;Bruckheimer;78;male;21.09.1942;producer",
                "Vitalik;Buterin;27;male;31.01.1994;software engineer",
                "Larry;Page;48;male;26.03.1973;Chief Executive Officer",
                "Marina;Abrosimova;38;female;10.06.1983;signer",
                "Ayn;Rand;77;female;20.01.1905;novelist"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out="
                + target.getAbsolutePath(), "-filter=firstName,lastName,birthDate"
        });
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "firstName;lastName;birthDate",
                "Keanu;Reeves;02.09.1964",
                "Angelina;Jolie;04.06.1975",
                "James;Cameron;16.08.1954",
                "Jerry;Bruckheimer;21.09.1942",
                "Vitalik;Buterin;31.01.1994",
                "Larry;Page;26.03.1973",
                "Marina;Abrosimova;10.06.1983",
                "Ayn;Rand;20.01.1905"
        ).concat(System.lineSeparator());
        CSVReader.handle(argsName);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }

}
