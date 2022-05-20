package ua.lviv.iot.bar;

public class IceBucket extends Bar_equipment {

	protected int bottles_that_fit;
	
	
	IceBucket(String material, int number_in_use, int number_in_storage, float price, int bottles_that_fit ) {
		super(material, number_in_use, number_in_storage, price);
		
		this.bottles_that_fit = bottles_that_fit;
	}
	
	public int GetBottles_that_fit() {
		return bottles_that_fit;
	}
	
	
	public void SetProducer( int bottles_that_fit ) {
		this.bottles_that_fit = bottles_that_fit;
	}
	

}
