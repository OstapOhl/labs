package ua.lviv.iot.writer;

import ua.lviv.iot.bar.Bar_equipment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class EquipmentWriter {

    public static void writeCSV(List<Bar_equipment> equipments) throws IOException {
        try (FileWriter writer = new FileWriter(new File("src/main/java/ua/lviv/iot/result/result.csv"))) {
            String previousClassName = "";
            for (Bar_equipment equipment : equipments) {
                if (!equipments.getClass().getSimpleName().equals(previousClassName)) {
                    writer.write(equipments.getClass() + "\r\n");
                    previousClassName = equipments.getClass().getSimpleName();
                }
                writer.write(equipment.ToCSV() + "\r\n");
            }
        }
    }
}
