package spanningusa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private Scanner inFile;
	private SpanningTree st;
	private String s = "";

	public Main(String fileName) {
		st = new SpanningTree();
		try {
			inFile = new Scanner(new File(fileName));

			String line = inFile.nextLine();
			while (!line.endsWith("]")) {
				String city;
				if (line.startsWith("\"")) {
					city = line.substring(1, line.length() - 2);
				} else {
					city = line.substring(0, line.length() - 1);
				}
				//s += city + "\n";
			
				st.addCity(city);
				line = inFile.nextLine();
			}
			//System.out.println(s);	
			while (inFile.hasNextLine()) {
				int index1 = line.indexOf("--");
				int index2 = line.indexOf("[");
				String city1 = line.substring(0, index1);
				if (city1.startsWith("\"")) {
					city1 = city1.substring(1, city1.length() - 1);
				}
				String neighbour = line.substring(index1 + 2, index2 - 1);
				if (neighbour.startsWith("\"")) {
					neighbour = neighbour.substring(1, neighbour.length() - 1);
				}
				line = line.substring(index2 + 1);
				int distance = Integer.parseInt(line.substring(0, line.length() - 1));
			//	System.out.println(city1 + "---" + neighbour + "---" + distance);
				st.addNeighbor(city1, neighbour, distance);
				line = inFile.nextLine();
		//		s += city1 + "-" + neighbour + "-" + distance + "\n";
			}
			int index1 = line.indexOf("-");
			int index2 = line.indexOf("[");
			String city1 = line.substring(0, index1);
			if (city1.startsWith("\"")) {
				city1 = city1.substring(1, city1.length() - 1);
			}
			String neighbour = line.substring(index1 + 2, index2 - 1);
			if (neighbour.startsWith("\"")) {
				neighbour = neighbour.substring(1, neighbour.length() - 1);
			}
			line = line.substring(index2 + 1);
			int distance = Integer.parseInt(line.substring(0, line.length() - 1));
			st.addNeighbor(city1, neighbour, distance);
		//	s += city1 + "-" + neighbour + "-" + distance + "\n";

		//	System.out.println(s);
			
			System.out.println(st.mst());
			st.printTree();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Main("USA-highway-miles.txt");
	//	new Main("tinyEWG-alpha.txt");

	}

}