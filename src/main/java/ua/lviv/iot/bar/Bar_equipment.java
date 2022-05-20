package ua.lviv.iot.bar;

public abstract class Bar_equipment {

	protected String material;
	protected int number_in_use;
	protected int number_in_storage;
	protected float price;
	
	Bar_equipment( String material, int number_in_use, int number_in_storage, float price )
	{
		this.material = material;
		this.number_in_use = number_in_use;
		this.number_in_storage = number_in_storage;
		this.price = price;
	}
	
	
	public String GetMaterial() {
		return material;
	}
	
	public int GetNumber_in_use() {
		return number_in_use;
	}
	
	public int GetNumber_in_storage() {
		return number_in_storage;
	}
	
	public float GetPrice() {
		return price;
	}
	
	
	public void SetMaterial( String material ) {
		this.material = material;
	}
	
	public void SetNumber_in_use(int number_in_use) {
		this.number_in_use = number_in_use;
	}
	
	public void SetNumber_in_storage(int number_in_storage) {
		this.number_in_storage = number_in_storage;
	}
	
	public void SetPrice(float price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Material: " + this.material + ",\nnumber in use: " + this.number_in_use + "\nnumber in storage: " + 
					this.number_in_storage + ",\nprice: " + this.price + "in uah.\n" + System.lineSeparator();
	}
	}
