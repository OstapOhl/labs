package ua.lviv.iot.manager;

import ua.lviv.iot.bar.Bar_equipment;

import java.util.*;



public class Manager implements IManager {

	private Map <String, List<Bar_equipment>> BarMap = new HashMap<>();
	
	@Override
	public void AddEquipment(List<Bar_equipment> equipment) {
		equipment.forEach(Bar_equipment -> {
			String material = Bar_equipment.GetMaterial();
			List<ua.lviv.iot.bar.Bar_equipment> exist = BarMap.get(material);
			if(exist == null) {
				exist = new LinkedList<Bar_equipment>();
				BarMap.put(material, exist);
			}
			exist.add((Bar_equipment) equipment);
		});
	}

	
	
	
	@Override
	public List<Bar_equipment> FindEquipmentByName(String name) {
		return BarMap.get(name);
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
