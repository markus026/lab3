package spanningusa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningTree  {
	ArrayList MST;
	int length;
	HashMap<String, PriorityQueue<City>> cities;

	public SpanningTree(){
		cities = new HashMap<String, PriorityQueue<City>>();
		MST = new ArrayList<String>();
	}

	public void addCity(String string) {
		if (!cities.containsKey(string)) {
			cities.put(string,new PriorityQueue<City>());
		}
	}
	public void addNeighbor(String city, String neighbour, int distance) {
		cities.get(city).add(new City(neighbour, distance));
	}
	
	public int size() {
		return cities.size();
	}

	public City getNeighbor(String name) {
		while (MST.contains(cities.get(name).peek())) {
			MST.contains(cities.get(name).remove());
		}
		return cities.get(name).poll();
	}

	public void calculateMST() {
		City current;
		String first;
		if (!cities.isEmpty()) {
			first = cities.entrySet().iterator().next().getKey();
			current = cities.get(first).poll();
			MST.add(first);
		} else {
			System.out.println("empty");
			return;
		}
		while (!cities.isEmpty()) {
			current = getNeighbor(current.name);
			MST.add(current.name);
			length += current.distance;
		}
	}
	
/*	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cities.size(); i++){
			String first = cities.entrySet().iterator().next().getKey();
			
			sb.append(current + "\n");
		}
		return sb.toString();
	}*/


	/*
	 * Create an empty priority queue. s ← any node in V. FOR EACH v ≠ s : d(v)
	 * ← ∞; d(s) ← 0. FOR EACH v : insert v with key d(v) into priority queue.
	 * WHILE (the priority queue is not empty) u ← delete-min from priority
	 * queue. FOR EACH edge (u, v) ∈ E incident to u: IF d(v) > c(u, v)
	 * decrease-key of v to c(u, v) in priority queue. d(v) ← c(u, v).
	 */
}
