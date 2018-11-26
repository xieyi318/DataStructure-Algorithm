import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum_quadratic {
	//return the number of triples sums to zero
	public static int count(ArrayList<Integer> a) {
		int N=a.size();
		int count=0;
		for(int i=0;i<N-2;i++) {
			int lo=i+1, hi=N-1, sum=0-a.get(i);
			while(lo<hi) {
				if(a.get(lo)+a.get(hi)==sum) {
					while(a.get(lo+1)==a.get(lo)&&lo<hi) {
						lo++;
						count++;
					}
					while(a.get(hi-1)==a.get(hi)&&lo<hi) {
						hi--;
						count++;
					}
					count++;
					lo++;
					hi--;
				}
				else if(a.get(lo)+a.get(hi)<sum) lo++;
				else hi--;
			}
			
		}
		return count;
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

	Collections.sort(list);
	long start,end;
	start = System.currentTimeMillis();
	
	//----------------stopwatch starts-------------------
	int result=ThreeSum_quadratic.count(list);
	System.out.println(result);
	//----------------stopwatch stops--------------------
	
	end = System.currentTimeMillis();  
	
	System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
	
	}
}