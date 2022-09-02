package com.example.demo;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
public class CsvDemo {
    @Test
    public void csvReadOperation() throws IOException {
       // File file = new File("src/main/resources/templates/test.csv");
        File file = new File("src/main/resources/templates/test.csv");
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);

        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        for (CsvRow row : csv.getRows()) {
            System.out.println("First column of line: " + row.getField("FO1"));
        }
    }
}
