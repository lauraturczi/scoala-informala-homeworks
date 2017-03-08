package quiz.third;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MerchandiseCalculator extends Thread {
	private int valueMerchandise;
	private double profit;
	private PackageDistribuitor packageDistribuitor;

	@Override
	public void run() {
		PackageDistribuitor packageDistribuitor = createEntries();
		HashMap<String, List<Package>> hmap = packageDistribuitor.gethMap();
		for (Map.Entry<String, List<Package>> entry : hmap.entrySet()) {
			List<Package> value = entry.getValue();
			profit = 0;
			valueMerchandise = 0;
			for (Package pack : value) {
				synchronized (this) {
					valueMerchandise = valueMerchandise + pack.getValue();
					profit = profit + (valueMerchandise * pack.getDistance() * 0.4);
				}
				try {
					Thread.sleep(pack.getDistance());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Profit per batch is : " + profit);
			System.out.println("Total merchandise value : " + valueMerchandise);
		}

	}

	private PackageDistribuitor createEntries() {

		PackageDistribuitor packageDistribuitor = new PackageDistribuitor();
		Package pack = new Package();
		Package secondPack = new Package();
		Package thirdPack = new Package();
		Package forthPack = new Package();
		Package fifthPack = new Package();
		pack.setLocation("cluj");
		secondPack.setLocation("alba");
		thirdPack.setLocation("cluj");
		forthPack.setLocation("satu mare");
		fifthPack.setLocation("satu mare");

		pack.setDistance(300);
		secondPack.setDistance(500);
		thirdPack.setDistance(300);
		forthPack.setDistance(400);
		fifthPack.setDistance(200);

		pack.setValue(100);
		secondPack.setValue(200);
		thirdPack.setValue(400);
		forthPack.setValue(150);
		fifthPack.setValue(100);

		packageDistribuitor.addPackage(pack);
		packageDistribuitor.addPackage(secondPack);
		packageDistribuitor.addPackage(thirdPack);
		packageDistribuitor.addPackage(forthPack);
		packageDistribuitor.addPackage(fifthPack);
		packageDistribuitor.createLists();
		return packageDistribuitor;
	}

}
