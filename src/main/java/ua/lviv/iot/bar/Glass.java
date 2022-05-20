package ua.lviv.iot.bar;

public class Glass extends Bar_equipment {

	protected int volume;
	protected String appointment;
	
	
	Glass( String material, int number_in_use, int number_in_storage, float price, int volume, String appointment) {
		super( material, number_in_use, number_in_storage, price);
		
		this.volume = volume;
		this.appointment = appointment;
		
	}

	public int GetVolume() {
		return volume;
	}
	
	public String GetAppointment() {
		return appointment;
	}
	
	
	public void SetVolume( int volume ) {
		this.volume = volume;
	}
	
	public void SetAppointment( String appointment ) {
		this.appointment = appointment;
	}
}
