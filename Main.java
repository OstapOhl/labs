package lab2;

public class Main {

	public static void main(String[] args) {

		Bar_equipment glass = new Glass( "glass", 6, 2, (float) 50.99, 250, "for coctails" );
		Bar_equipment opener = new Opener( "plastic", 2, 1, (float) 399.99, "xiaomi", 350 );
		Bar_equipment bucket = new IceBucket( "aluminium", 5, 2, (float) 215.49, 3 );

		
		System.out.println( glass.toString() );
		System.out.println( opener.toString() );
		System.out.println( bucket.toString() );

	}

}




