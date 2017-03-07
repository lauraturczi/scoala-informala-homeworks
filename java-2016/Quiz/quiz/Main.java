package quiz;

public class Main {

	public static void main(String[] args) {
		Package pack = new Package();
		
		MerchandiseValueCalculator calculator = new MerchandiseValueCalculator(pack);
		pack.setDistance(756);
		pack.start();
		calculator.start();

	}

}
