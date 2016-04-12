package spanningusa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAll {


	@Test
	public void testSize() {
		SpanningTree tree = new SpanningTree();
		tree.addCity("city1");
		tree.addCity("city2");
		tree.addCity("city3");
		tree.addCity("city1");
		assertEquals(3,tree.size()); 
	}
	
	@Test
	public void testInsertion() {
		SpanningTree tree = new SpanningTree();
		tree.addCity("city1");
		tree.addNeighbor("city1", "Neighbor1", 10);
		tree.addNeighbor("city1", "Neighbor2", 1140);
		tree.addNeighbor("city1", "Neighbor3", 1);
		
		
		assertEquals("\n"
				   + "Neighbor3 =  1" + "\n"
				   + "Neighbor1 =  10" + "\n"
				   + "Neighbor2 =  11401", tree.toString());
	}
	
	@Test
	public void testCalc() {
		SpanningTree tree = new SpanningTree();
		tree.addCity("city1");
		tree.addCity("city2");
		tree.addCity("city3");
		tree.addNeighbor("city1", "city2", 10);
		tree.addNeighbor("city1", "city3", 1140);
		tree.addNeighbor("city2", "city1", 10);
		tree.addNeighbor("city2", "city3", 103);
		tree.addNeighbor("city3", "city1", 1140);
		tree.addNeighbor("city3", "city2", 103);
		
		assertEquals("[city2, city3, city1], total length = 1243", tree.calculateMST());
	}

}
