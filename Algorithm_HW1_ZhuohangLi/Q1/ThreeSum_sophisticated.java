
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ThreeSum_sophisticated {
	//return the number of triples sums to zero
	public static int count(ArrayList<Integer> a) {
		int N=a.size();
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(binarySearch(a,-a.get(i)-a.get(j))>j)
					count++;
				}
			}
		return count;
	}
	
	public static int binarySearch(ArrayList<Integer> a, int key) {
		int lo =0;
		int hi = a.size()-1;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if(key<a.get(mid))hi=mid-1;
			else if (key>a.get(mid))lo=mid+1;
			else return mid;
		}
		return -1;
	}
	
	//takes the file name and read in the files and put it in arraylist
    public static ArrayList<Integer> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                list.add(Integer.parseInt(tempString));
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
        return list;
    }
	
public static void main(String args[]) {
	ArrayList<Integer> list;
	if(args.length==1) {
		list=readFileByLines(args[0]);
	}
	else {
		list=new ArrayList<Integer>();
		for(int i=0;i<args.length;i++) {
			list.add(Integer.valueOf(args[i]));
		}
	}
	
	
	long start,end;
	start = System.currentTimeMillis();
	
	//----------------stopwatch starts-------------------
	int result=ThreeSum_sophisticated.count(list);
	System.out.println(result);
	//----------------stopwatch stops--------------------
	
	end = System.currentTimeMillis();  
	System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
	
	}
}