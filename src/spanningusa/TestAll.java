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

}
