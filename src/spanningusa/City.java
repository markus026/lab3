package spanningusa;


public class City implements Comparable {
	String name;
	int distance;
	String origin = "";
	
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

	public void setOrigin(String s){
		origin = s;
	}
	
	@Override
	public int compareTo(Object o) {
		return(distance - ((City) o).getDistance());
	}
}
