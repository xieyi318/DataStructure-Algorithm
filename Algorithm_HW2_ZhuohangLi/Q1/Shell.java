public class Shell {
    private static int count;//count number of comparisons

    public static int sort(Comparable[] a) {
        count=0;
        int n= a.length;
        int h=7;
        while(h>=1){
            for (int i=h;i<n;i++)
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exchange(a, j, j - h);
            h=h/2;
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

    public static void main(String[] args){
        String[]a =args;
        System.out.println(sort(a));
        assert isSorted(a);
        show(a);
    }
}
