package labs;

public record Shoes(String name, String colour, double price, int size) 
{ 
	static String gender = "For male";

	public Shoes() {
		this("unknown", "unknown", 0, 0);
	}

	public Shoes(String colour, double price, int size) {
		this (null, colour, 0, 0);
	}

	public static String gender() {
		return gender;
	}

	@Override
	public String toString() {
		return String.format("Name: '%s', colour: %s, price: %.2f, size: %d ", name, colour, price, size);
	}
}		
