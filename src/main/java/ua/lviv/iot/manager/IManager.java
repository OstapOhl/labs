package ua.lviv.iot.manager;


import ua.lviv.iot.bar.Bar_equipment;

import java.util.List;

public interface IManager {
	
	void AddEquipment(List<Bar_equipment> equipment);
	
	void PriceSort(List<Bar_equipment> equipment);
	
	void PriceAscendingSort(List<Bar_equipment> equipment);
		
	List<Bar_equipment> FindEquipmentByMaterial(String name);



}

