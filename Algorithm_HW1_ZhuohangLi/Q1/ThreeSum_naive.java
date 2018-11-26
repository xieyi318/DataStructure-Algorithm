import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ThreeSum_naive {
	//return the number of triples sums to zero
	public static int count(ArrayList<Integer> a) {
		int N=a.size();
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
					if(a.get(i)+a.get(j)+a.get(k)==0)
						count++;
				}
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
//	for(int i=0;i<list.size();i++) {
//		System.out.println(list.get(i));
//	}
	long start,end;
	start = System.currentTimeMillis();
//	start = System.nanoTime();
	
	//----------------stopwatch starts-------------------
	int result=ThreeSum_naive.count(list);
	System.out.println(result);
	//----------------stopwatch stops--------------------
	
	end = System.currentTimeMillis();  
//	end = System.nanoTime();  
	System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
	
	}
}