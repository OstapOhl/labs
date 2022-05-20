package ua.lviv.iot.bar;

public class Opener extends Bar_equipment {

	protected String producer;
	protected int weight;
	
	
	Opener(String material, int number_in_use, int number_in_storage, float price, String producer, int weight) {
		super(material, number_in_use, number_in_storage, price);
		
		this.producer = producer;
		this.weight = weight;
	}

	public String GetProducer() {
		return producer;
	}
	
	public int GetWeight() {
		return weight;
	}
	
	
	public void SetProducer( String producer ) {
		this.producer = producer;
	}
	
	public void SetAppointment( int weight ) {
		this.weight = weight;
	}
	
}

