package quiz.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PackageDistribuitor creates a hashmap where it stores packages that need to
 * be shipped. The key is represented by the location and the values are
 * represented by the list of packages with the same location
 * 
 * @author Laura
 * @version 3.0
 *
 */
public class PackageDistribuitor {
	private List<Package> sharedQueue = new LinkedList<Package>();
	private Package pack;
	private HashMap<String, List<Package>> hMap = new HashMap<>();

	public HashMap<String, List<Package>> gethMap() {
		return hMap;
	}

	@Override
	public String toString() {
		return "PackageDistribuitor [hMap=" + hMap + "]";
	}

	/**
	 * Adds a package to a list
	 * 
	 * @param pack
	 */
	public void addPackage(Package pack) {
		this.sharedQueue.add(pack);

	}

	/**
	 * Creates the HashMap based on the location the package need to be shipped
	 */
	public void createLists() {

		for (int i = 0; i < sharedQueue.size(); i++) {
			List<Package> list = hMap.get(sharedQueue.get(i).getLocation());
			if (list == null) {
				list = new ArrayList<>();
				hMap.put(sharedQueue.get(i).getLocation(), list);
			}
			list.add(sharedQueue.get(i));
		}
	}

	/**
	 * Returns a list with all the packages
	 * 
	 * @return allpackages
	 */
	public List<Package> getAllPackages() {
		List<Package> allpackages = new ArrayList<>();
		for (List<Package> packages : hMap.values()) {
			allpackages.addAll(packages);
		}
		Collections.sort(allpackages);
		return allpackages;
	}

	/**
	 * Lists the key value pair in the HashMap
	 */
	public void listPackages() {
		Set set = hMap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}

	}

}
