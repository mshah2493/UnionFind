public class UF implements UFI {
	
	private int[] id;
	private int[] size;
	private int[] largest;
	private int count;
	
	public UF(int n) 
	{ 
		id = new int[n];
		size = new int[n];
		largest = new int[n];
		count = n;
		
		for(int i = 0; i < n; i++)
		{
			id[i] = i;
			size[i] = 1;
			largest[i] = i;
		}
	}
	
	public int root(int n) 
	{
		while (n != id[n]) 
		{
			id[n] = id[id[n]];
			n = id[n];
		}
		
		return n;
	}

	public void union(int p, int q) 
	{
		int rootP = root(p);
		int rootQ = root(q);

		if (rootP == rootQ)
			return;

		if (size[rootP] > size[rootQ]) 
		{
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} 
		else 
		{
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		
		if (largest[rootP] > largest[rootQ])
		{
			largest[rootQ] = largest[rootP];
		}
		else
		{
			largest[rootP] = largest[rootQ];
		}
		
		--count;
	}

	public boolean connected(int p, int q) 
	{
		return root(p) == root(q);
	}

	public int count() 
	{
		return count;
	}

	public int find(int i) 
	{
        return largest[root(i)];
	}
	
	public void delete(int x)
	{
		if (x == id.length - 1) return;
        
		union(x, x + 1);
    }

    public int getSuccessor(int x)
    {
        return largest[root(x)];
    }
}
