public interface UFI {
	void union(int p, int q); //add connection between p and q
	boolean connected(int p, int q); // are p and q in the same component?
	int find(int p); //component identifier for p (0 to N – 1)
	int root(int n);
	int count(); //number of components
	void delete(int x);
	int getSuccessor(int x);
}
