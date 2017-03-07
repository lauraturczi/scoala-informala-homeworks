package quiz;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PackageDistribuitor {
	private Queue<Package> packages = new ConcurrentLinkedQueue<Package>();
	private Package pack;
	public Boolean continueProducing = Boolean.TRUE;

	public  Queue<Package> getPackages() {
		return packages;
	}

	public void addPackage(Package pack){
		this.packages.add(pack);
		
	}
	

}
