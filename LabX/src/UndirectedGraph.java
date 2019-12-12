import java.util.Queue;


public class UndirectedGraph<T> implements BasicGraphInterface <T> {
	
	private DirectedGraph digraph;
	
	public UndirectedGraph() {
		
	}

	public boolean addVertex(T vertexLabel) {
		return false;
	}

		public boolean addEdge(T begin, T end, double edgeWeight) {
		return false;
	}

	
	public boolean addEdge(T begin, T end) {
		return false;
	}

	
	public boolean hasEdge(T begin, T end) {
		return false;
	}

	
	public boolean isEmpty() {
		return false;
	}

	
	public int getNumberOfVertices() {
		return 0;
	}

	
	public int getNumberOfEdges() {
		return 0;
	}

	
	public void clear() {
		
	}
	
	public Queue<T> getBreadthFirstTraversal(T origin) {
		return null;
	}
	
	public Queue<T> getDepthFirstTraversal(T origin) {
		return null;
	}
	
	
	public boolean isConnected(T origin) {
		return false;
	}

}
