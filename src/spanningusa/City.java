package spanningusa;

public class City implements Comparable {
	String name;
	int distance;
	
	public City(String string, int distance) {
		this.name = string;
		this.distance = distance;
	}
	
	public int getDistance(){
		return distance;
	}

	public int compareTo(City arg0) {
		return (distance - arg0.getDistance());
	}

	@Override
	public int compareTo(Object o) {
		return(distance - ((City) o).getDistance());
	}
}
