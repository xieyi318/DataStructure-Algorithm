import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuickUnion{


	private int[] id;
	private int count;
	public QuickUnion(int n)
	{
		count=n;
		id=new int[n];
		for(int i=0;i<n;i++)
			id[i]=i;
	}
		
	public int count()
	{return count;}
		
	public boolean connected(int p,int q)
	{return find(p)==find(q);}
	
	public int find(int p) 
	{
		while(p!=id[p]) p=id[p];
		return p;
	}
	public void union(int p, int q) 
	{
		int i=find(p);
		int j=find(q);
		if(i==j)return;
		id[i]=j;
		count--;
	}
	
	public static void main(String[] args) 
	{
		File file = new File(args[0]);
        BufferedReader reader = null;
        ArrayList<Integer> plist = new ArrayList<Integer>();
        ArrayList<Integer> qlist = new ArrayList<Integer>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	String []token=tempString.split(" ");
                plist.add(Integer.parseInt(token[0]));
                qlist.add(Integer.parseInt(token[1]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		
        int n=plist.size();       
        QuickUnion qu= new QuickUnion(8192);
        
    	long start,end;
    	start = System.currentTimeMillis();
    	
    	//----------------stopwatch starts-------------------
        for(int i=0;i<n;i++)
        {
        	int p=plist.get(i);
        	int q=qlist.get(i);
        	if(qu.connected(p, q)) continue;
        	qu.union(p, q);
        	System.out.println(p+" "+q);
        }
    	//----------------stopwatch stops--------------------
        
        end = System.currentTimeMillis(); 
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
        System.out.println(qu.count()+"components");
	}

}