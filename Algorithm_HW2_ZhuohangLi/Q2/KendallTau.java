import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KendallTau {

    public static int distance(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array dimensions disagree");
        }
        int n = a.length;

        int[] ainv = new int[n];
        for (int i = 0; i < n; i++)
            ainv[a[i]] = i;

        int[] bnew = new int[n];
        for (int i = 0; i < n; i++)
            bnew[i] = ainv[b[i]];

        return mergeSort(bnew,0,n-1);
    }

    private static int mergeSort(int[] array, int start, int end)
    {
        if(start < end)
        {
            int middle = start + (end - start) / 2;
            return mergeSort(array, start, middle)+
            mergeSort(array, middle + 1, end)+
            merge(array, start, middle, end);
        }
        else
            return 0;
    }

    private static int merge(int[] a, int start, int middle, int end)
    {
        int count=0;
        int[] array = new int[end - start + 1];
        int i = 0, j = start, k = middle + 1;
        while(j <= middle && k <= end)
        {
            if(a[j] <= a[k])
                array[i++] = a[j++];
            else
            {
                count += middle - j + 1;
                array[i++] = a[k++];
            }
        }
        while(j <= middle)
            array[i++] = a[j++];
        while(k <= end)
            array[i++] = a[k++];
        for(i = 0; i < array.length; i++)
            a[start + i] = array[i];
        return count;
    }

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

    public static void main(String[] args){
        ArrayList<Integer> listA;
        listA=readFileByLines(args[0]);
        Integer[]A=listA.toArray(new Integer[listA.size()]);
        int[] a=new int[A.length];
        for (int i = 0; i <A.length ; i++) {
            a[i]=A[i].intValue()-1;
            System.out.print(a[i]+" ");
        }

        System.out.println();

        ArrayList<Integer> listB;
        listB=readFileByLines(args[1]);
        Integer[]B=listB.toArray(new Integer[listB.size()]);
        int[] b=new int[B.length];
        for (int i = 0; i <B.length ; i++) {
            b[i]=B[i].intValue()-1;
            System.out.print(b[i]+" ");
        }
        System.out.println();

        long start,end;
        start = System.currentTimeMillis();

        System.out.println(distance(a,b));

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + "(ms)");
    }
}
