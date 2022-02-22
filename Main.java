package labs;

public class Main {
	
public static void main(String[] args) {
		
		Shoes firstPair = new Shoes("Nike", "red", 49.99, 43);
		Shoes secondPair = new Shoes();
		Shoes thirdPair = new Shoes("pink", 89, 38);
		
		
		System.out.println(firstPair.toString());
		System.out.println(secondPair.toString());
		System.out.println(thirdPair.toString());
		System.out.println(Shoes.gender);
	}

}