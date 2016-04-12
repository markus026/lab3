package spanningusa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningTree {
	// ArrayList MST;
	int length;
	HashMap<String, PriorityQueue<City>> cities;
	HashMap<String, ArrayList<String>> mst;

	public SpanningTree() {
		cities = new HashMap<String, PriorityQueue<City>>();
		mst = new HashMap<String, ArrayList<String>>();
		// MST = new ArrayList<String>();
	}

	public void addCity(String string) {
		if (!cities.containsKey(string)) {
			cities.put(string, new PriorityQueue<City>());
		}
	}

	public void addNeighbor(String city, String neighbour, int distance) {
		cities.get(city).add(new City(neighbour, distance));
		cities.get(neighbour).add(new City(city, distance));
	}

	public int size() {
		return cities.size();
	}

	public int mst() {
		ArrayList<String> unvisitedCities = new ArrayList<String>();
		for (String s : cities.keySet()) {
			mst.put(s, new ArrayList<String>());
			unvisitedCities.add(s);
		}
		
		HashMap<String, ArrayList<City>> tempEdges = new HashMap<String, ArrayList<City>>();
		PriorityQueue<City> nextEdges = new PriorityQueue<City>();
		String nextCity = unvisitedCities.get(unvisitedCities.size() - 1);
		while (unvisitedCities.size() > 1) {
			unvisitedCities.remove(nextCity);
			for (City city1 : cities.get(nextCity)) {
				if (unvisitedCities.contains(city1.name)) {
					city1.setOrigin(nextCity);
					nextEdges.add(city1);
				}
			}
			if (!nextEdges.isEmpty()) {
				City city2 = nextEdges.poll();
				mst.get(city2.origin).add(city2.name);
				mst.get(city2.name).add(city2.origin);
				length += city2.distance;
			//	System.out.println(length);
				nextCity = city2.name;
			} else if (!unvisitedCities.isEmpty()) {
				nextCity = unvisitedCities.get(unvisitedCities.size() - 1);
			}
		}
		return length;
	}

	public void printTree() {
		for (String rootCity : mst.keySet()) {
			System.out.print(rootCity + ": ");
			for(String leafCity : mst.get(rootCity)){
				System.out.print(leafCity + "\t");
			}
			System.out.println();
		}
	}

}
