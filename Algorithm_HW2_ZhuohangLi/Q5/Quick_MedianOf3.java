public class Quick_MedianOf3 {
    private static int count;//count number of comparisons

    public static int sort(Comparable[] a){
        count=0;
        //shuffle(a);
        sort(a,0,a.length-1);
        return count;
    }

    private static void sort(Comparable[]a, int lo, int hi){
        if(hi<=lo) return;
        int j =partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[]a, int lo, int hi){
        int i=lo, j=hi+1;
        int mid=(lo+hi)/2;
        if(less(a[lo],a[hi])){
            if(less(a[lo],a[mid]))
                if(less(a[mid],a[hi])) exchange(a,mid,lo);
                else exchange(a,hi,lo);
        }
        else if(less(a[mid],a[lo]))
            if(less(a[mid],a[hi])) exchange(a,hi,lo);
            else exchange(a,mid,lo);

        Comparable v=a[lo];

        while (true){
            while (less(a[++i],v)) if(i==hi)break;
            while (less(v,a[--j])) if(j==lo)break;
            if(i>=j) break;
            exchange(a,i,j);
        }
        exchange(a,lo,j);
        return j;
    }

    private static void shuffle(Comparable[] a){
        int n=a.length;
        for(int i=0;i<n;i++){
            int r=i+(int)Math.round((n-1-i)*Math.random());
            Comparable temp=a[i];
            a[i]=a[r];
            a[r]=temp;
        }
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
        shuffle(a);
        show(a);
        sort(a);
        show(a);
    }
}
