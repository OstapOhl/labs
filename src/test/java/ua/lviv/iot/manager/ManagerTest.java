package ua.lviv.iot.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.bar.Bar_equipment;
import ua.lviv.iot.bar.Glass;
import ua.lviv.iot.bar.Opener;
import ua.lviv.iot.bar.IceBucket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

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
    }


    @Test
    void findEquipmentByNameTest() {

        List<Bar_equipment> data = Manager.FindEquipmentByMaterial("glass");
        Assertions.assertEquals("glass", data.get(0).GetMaterial());

    }

    @Test
    void priceSortTest() {
        Manager.PriceSort(equipments);

        Assertions.assertEquals("plastic", equipments.get(0).GetMaterial());
        Assertions.assertEquals((float) 399.99, equipments.get(0).GetPrice());
        Assertions.assertEquals(2, equipments.get(0).GetNumber_in_use());
        Assertions.assertEquals(1, equipments.get(0).GetNumber_in_storage());

        Assertions.assertEquals("aluminium", equipments.get(1).GetMaterial());
        Assertions.assertEquals((float) 215.49, equipments.get(1).GetPrice());
        Assertions.assertEquals(5, equipments.get(1).GetNumber_in_use());
        Assertions.assertEquals(2, equipments.get(1).GetNumber_in_storage());

        Assertions.assertEquals("glass", equipments.get(2).GetMaterial());
        Assertions.assertEquals((float) 50.99, equipments.get(2).GetPrice());
        Assertions.assertEquals(6, equipments.get(2).GetNumber_in_use());
        Assertions.assertEquals(2, equipments.get(2).GetNumber_in_storage());

    }

    @Test
    void priceAscendingSortTest() {
        Manager.PriceAscendingSort(equipments);

        Assertions.assertEquals("glass", equipments.get(0).GetMaterial());
        Assertions.assertEquals((float) 50.99, equipments.get(0).GetPrice());
        Assertions.assertEquals(6, equipments.get(0).GetNumber_in_use());
        Assertions.assertEquals(2, equipments.get(0).GetNumber_in_storage());

        Assertions.assertEquals("aluminium", equipments.get(1).GetMaterial());
        Assertions.assertEquals((float) 215.49, equipments.get(1).GetPrice());
        Assertions.assertEquals(5, equipments.get(1).GetNumber_in_use());
        Assertions.assertEquals(2, equipments.get(1).GetNumber_in_storage());

        Assertions.assertEquals("plastic", equipments.get(2).GetMaterial());
        Assertions.assertEquals((float) 399.99, equipments.get(2).GetPrice());
        Assertions.assertEquals(2, equipments.get(2).GetNumber_in_use());
        Assertions.assertEquals(1, equipments.get(2).GetNumber_in_storage());

    }
}