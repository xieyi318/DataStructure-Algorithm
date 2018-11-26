public class Merge_Cutoff {
    private static Comparable[] aux;
    private static int count;//count number of comparisons
    private static int cutoff;

    public static void setCutoff(int a){
        cutoff=a;
    }

    public static int sort(Comparable[] a){
        count=0;
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
        return count;
    }

    private static void sort(Comparable[]a, int lo, int hi){
        if(hi<=lo + cutoff){insertionSort(a,lo,hi); return;}
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
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

    private static void insertionSort(Comparable[]a, int lo, int hi){
        for(int i=lo+1;i<hi+1;i++){
            for(int j=i;j>lo && less(a[j],a[j-1]);j--)
                exchange(a, j, j - 1);
        }
    }

    public static void main(String[] args){
        String[]a =args;
        setCutoff(3);
        System.out.println(sort(a));
        assert isSorted(a);
        show(a);
    }
}
