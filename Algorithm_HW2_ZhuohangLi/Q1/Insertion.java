public class Insertion {
    private static int count;//count number of comparisons

    public static int sort(Comparable[] a) {
        int n=a.length;
        count=0;
        for(int i=1;i<n;i++){
            for(int j=i;j>0 && less(a[j],a[j-1]);j--)
                exchange(a, j, j - 1);
        }
        return count;
    }

    private static boolean less(Comparable v, Comparable w){
        count++;
        return v.compareTo(w)<0;
    }

    private static void exchange(Comparable[]a, int i, int j){
        Comparable t= a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static void show(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[]a){
        for (int i=1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
}
