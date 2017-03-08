package quiz.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public void addPackage(Package pack) {
		this.sharedQueue.add(pack);

	}

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

	public List<Package> getAllPackages() {
		List<Package> allpackages = new ArrayList<>();
		for (List<Package> packages : hMap.values()) {
			allpackages.addAll(packages);
		}
		Collections.sort(allpackages);
		return allpackages;
	}

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
