package spanningusa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAll {


//	@Test
//	public void testSize() {
//		SpanningTree tree = new SpanningTree();
//		tree.addCity("city1");
//		tree.addCity("city2");
//		tree.addCity("city3");
//		tree.addCity("city1");
//		assertEquals(3,tree.size()); 
//	}
//	
//	@Test
//	public void testInsertion() {
//		SpanningTree tree = new SpanningTree();
//		tree.addCity("city1");
//		tree.addNeighbor("city1", "Neighbor1", 10);
//		tree.addNeighbor("city1", "Neighbor2", 1140);
//		tree.addNeighbor("city1", "Neighbor3", 1);
//		
//		
//		assertEquals("\n"
//				   + "Neighbor3 =  1" + "\n"
//				   + "Neighbor1 =  10" + "\n"
//				   + "Neighbor2 =  11401", tree.toString());
//	}
//	
//	@Test
//	public void testCalc() {
//		SpanningTree tree = new SpanningTree();
//		tree.addCity("city1");
//		tree.addCity("city2");
//		tree.addCity("city3");
//		tree.addNeighbor("city1", "city2", 10);
//		tree.addNeighbor("city2", "city1", 10);
//		tree.addNeighbor("city1", "city3", 1140);
//		tree.addNeighbor("city3", "city1", 1140);
//		tree.addNeighbor("city2", "city3", 103);
//		tree.addNeighbor("city3", "city2", 103);
//		
//		assertEquals("[city2, city3, city1], total length = 1243", tree.calculateMST());
//	}
	
	@Test
	public void testMst(){
		SpanningTree tree = new SpanningTree();
		tree.addCity("Eslov");
		tree.addCity("Lund");
		tree.addCity("Malmo");
		tree.addCity("Kristianstad");
		tree.addCity("Ystad");
		tree.addCity("Simrishamn");
		tree.addCity("Stockholm");
		tree.addCity("h");
		
		tree.addNeighbor("Eslov", "Lund", 24);
		tree.addNeighbor("Eslov", "Malmo", 4);
		tree.addNeighbor("Lund", "Kristianstad", 23);
		tree.addNeighbor("Lund", "Ystad", 18);
		tree.addNeighbor("Lund", "Simrishamn", 9);
		tree.addNeighbor("Malmo", "Kristianstad", 6);
		tree.addNeighbor("Malmo", "Stockholm", 16);
		tree.addNeighbor("Kristianstad", "Ystad", 5);
		tree.addNeighbor("Kristianstad", "Stockholm", 8);
		tree.addNeighbor("Ystad", "Simrishamn", 11);
		tree.addNeighbor("Ystad", "Stockholm", 10);
		tree.addNeighbor("Ystad", "h", 14);
		tree.addNeighbor("Simrishamn", "h", 7);
		tree.addNeighbor("Stockholm", "h", 21);
	//System.out.println(tree.mst());
	}
	
	@Test
	public void testMst2(){
			SpanningTree tree = new SpanningTree();
			tree.addCity("1");
			tree.addCity("2");
			tree.addCity("3");
			tree.addCity("4");
			tree.addCity("5");
			tree.addCity("6");
			tree.addCity("7");
			tree.addCity("8");
			
			tree.addNeighbor("1", "2", 24);
			tree.addNeighbor("1", "3", 4);
			tree.addNeighbor("2", "4", 23);
			tree.addNeighbor("2", "5", 18);
			tree.addNeighbor("2", "6", 9);
			tree.addNeighbor("3", "4", 6);
			tree.addNeighbor("3", "7", 16);
			tree.addNeighbor("4", "5", 5);
			tree.addNeighbor("4", "7", 8);
			tree.addNeighbor("5", "6", 11);
			tree.addNeighbor("5", "7", 10);
			tree.addNeighbor("5", "8", 14);
			tree.addNeighbor("6", "8", 7);
			tree.addNeighbor("7", "8", 21);
		System.out.println(tree.mst());
		tree.printTree();
				
		}
 
	@Test
	public void simpleTest(){
		SpanningTree tree = new SpanningTree();
		tree.addCity("a");
		tree.addCity("b");
		tree.addCity("c");
		tree.addCity("d");
		tree.addNeighbor("a", "b", 3);
		tree.addNeighbor("c", "b", 2);
		tree.addNeighbor("d", "b", 4);
		tree.addNeighbor("a", "d", 1);
	//	tree.addNeighbor("a", "c", 1);
		//System.out.println(tree.mst());
		//tree.printTree();
	}
	
}
