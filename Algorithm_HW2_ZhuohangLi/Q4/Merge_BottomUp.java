public class Merge_BottomUp {
    private static Comparable[] aux;
    private static int count;//count number of comparisons

    public static int sort(Comparable[] a){
        count=0;
        int n=a.length;
        aux=new Comparable[n];
        for(int len=1; len<n; len*=2)
            for(int lo=0; lo<n-len; lo+=len+len)
                merge(a,lo,lo+len-1,Math.min(lo+len+len-1,n-1));
        return count;
    }

    private static void merge(Comparable[]a, int lo, int mid, int hi){
        int i=lo, j=mid+1;
        for(int k =lo; k<=hi;k++)
            aux[k]=a[k];
        for(int k = lo; k<= hi; k++)
            if(i>mid)
                a[k]=aux[j++];
            else if(j>hi)
                a[k]=aux[i++];
            else if(less(aux[j],aux[i]))
                a[k]=aux[j++];
            else
                a[k]=aux[i++];
    }

    private static boolean less(Comparable v, Comparable w){
        count++;
        return v.compareTo(w)<0;
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
