package ua.lviv.iot.writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import ua.lviv.iot.bar.Bar_equipment;
import ua.lviv.iot.bar.Glass;
import ua.lviv.iot.bar.IceBucket;
import ua.lviv.iot.bar.Opener;
import ua.lviv.iot.manager.Manager;
import ua.lviv.iot.writer.EquipmentWriter;


import java.util.LinkedList;
import java.util.List;


class EquipmentWriterTest {

    private List<Bar_equipment> equipments;
    private Manager Manager;

    @BeforeEach
    void Data() throws Exception {

        equipments = new LinkedList<>();

        equipments.add(new Glass("glass", 6, 2, (float) 50.99, 250, "for coctails"));
        equipments.add(new Opener("plastic", 2, 1, (float) 399.99, "xiaomi", 350));
        equipments.add(new IceBucket("aluminium", 5, 2, (float) 215.49, 3));

        Manager = new Manager();
        Manager.AddEquipment(equipments);

        EquipmentWriter.writeCSV(new LinkedList<>());
        EquipmentWriter.writeCSV(equipments);
    }

    @Test
    void writeCSV() throws IOException {
        try (
                FileReader expectedReader = new FileReader(new File("src/main/java/ua/lviv/iot/result/expected.csv"));
                BufferedReader expectedBR = new BufferedReader(expectedReader);
                FileReader actualReader = new FileReader(new File("src/main/java/ua/lviv/iot/result/result.csv"));
                BufferedReader actualBR = new BufferedReader(actualReader)) {
            String expectedLine = "";
            while ((expectedLine = expectedBR.readLine()) != null) {
                Assertions.assertEquals(expectedLine, actualBR.readLine());
            }
        }
    }


}