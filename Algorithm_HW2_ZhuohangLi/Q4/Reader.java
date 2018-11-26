import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static int[] readToInt(String fileName){
        ArrayList<Integer> listA;
        listA=readFileByLines(fileName);
        Integer[]A=listA.toArray(new Integer[listA.size()]);
        int[] a=new int[A.length];
        for (int i = 0; i <A.length ; i++) {
            a[i]=A[i].intValue()-1;
        }
        return a;
    }

    public static Integer[] readToInteger(String fileName){
        ArrayList<Integer> listA;
        listA=readFileByLines(fileName);
        Integer[]A=listA.toArray(new Integer[listA.size()]);
        return A;
    }

    private static ArrayList<Integer> readFileByLines(String fileName) {
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
}
