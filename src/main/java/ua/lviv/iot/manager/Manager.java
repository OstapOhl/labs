package ua.lviv.iot.manager;

import ua.lviv.iot.bar.Bar_equipment;

import java.util.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Manager implements IManager {

    private final Map<String, List<Bar_equipment>> BarMap = new HashMap<>();

    @Override
    public void AddEquipment(List<Bar_equipment> events) {
        events.forEach(event -> {
            String name = event.GetMaterial();
            List<Bar_equipment> availableEquipment = BarMap.get(name);
            if (availableEquipment == null) {
                availableEquipment = new LinkedList<Bar_equipment>();
                BarMap.put(event.GetMaterial(), availableEquipment);
            }
            availableEquipment.add(event);
        });
    }


    @Override
    public List<Bar_equipment> FindEquipmentByMaterial(String material) {
        return BarMap.get(material);
    }


    @Override
    public void PriceSort(List<Bar_equipment> equipment) {

        equipment.sort(Collections.reverseOrder(Comparator.comparing(Bar_equipment::GetPrice)));

    }

    @Override
    public void PriceAscendingSort(List<Bar_equipment> equipment) {

        equipment.sort(Comparator.comparing(Bar_equipment::GetPrice));

    }


}
