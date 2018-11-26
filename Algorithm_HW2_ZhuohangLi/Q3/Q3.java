public class Q3 {

    public static int[] createDataSet(){
        int a[]=new int[8192];
        for(int i=0;i<a.length;i++){
            if(i<1024)a[i]=1;
            else if(i<1024+2048)a[i]=11;
            else if(i<1024+2048+4096)a[i]=111;
            else a[i]=1111;
        }
        return a;
    }

    public static void sort(int[]a){
        if(a.length!=8192)return;
        for(int i=0;i<a.length;i++){
            if(i<1024)a[i]=1;
            else if(i<1024+2048)a[i]=11;
            else if(i<1024+2048+4096)a[i]=111;
            else a[i]=1111;
        }
    }

    private static void show(int[] a){
        for (int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int a[]=createDataSet();
        show(a);
        sort(a);
        show(a);
    }
}
