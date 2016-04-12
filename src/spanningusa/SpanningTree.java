package spanningusa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningTree {
	int length;
	HashMap<String, ArrayList<City>> cities;
	HashMap<String, ArrayList<String>> mst;

	public SpanningTree() {
		cities = new HashMap<String, ArrayList<City>>();
		mst = new HashMap<String, ArrayList<String>>();
	}

	public void addCity(String string) {
		if (!cities.containsKey(string)) {
			cities.put(string, new ArrayList<City>());
		}
	}

	public void addNeighbor(String city, String neighbour, int distance) {
		cities.get(city).add(new City(neighbour, distance));
		cities.get(neighbour).add(new City(city, distance));
//		}
//		catch(NullPointerException ex){
//			System.out.println(city + "||" + neighbour + "||" + distance);
//		}
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
				while(!unvisitedCities.contains(city2.name)){
					city2 = nextEdges.poll();
				}
				mst.get(city2.origin).add(city2.name);
				mst.get(city2.name).add(city2.origin);
				length += city2.distance;
				nextCity = city2.name;
			} else if (!unvisitedCities.isEmpty()) {
				nextCity = unvisitedCities.get(unvisitedCities.size() - 1);
			}
		}
		return length;
	}

	public void printTree() {
		for (String rootCity : mst.keySet()) {
			if(rootCity.length() < 7){
				System.out.print(rootCity + ":\t\t\t");	
			}
			else{
			System.out.print(rootCity + ":\t\t");
			}
			for(String leafCity : mst.get(rootCity)){
				System.out.print(leafCity + ",\t");
			}
			System.out.println();
		}
	}

}
