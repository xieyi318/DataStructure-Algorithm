public class Q5 {
    public static void main(String[] args){
        Integer a1024[]=Reader.readToInteger("data0.1024");
        Integer a2048[]=Reader.readToInteger("data0.2048");
        Integer a4096[]=Reader.readToInteger("data0.4096");
        Integer a8192[]=Reader.readToInteger("data0.8192");
        Integer a16384[]=Reader.readToInteger("data0.16384");
        Integer a32768[]=Reader.readToInteger("data0.32768");

        Integer b1024[]=Reader.readToInteger("data1.1024");
        Integer b2048[]=Reader.readToInteger("data1.2048");
        Integer b4096[]=Reader.readToInteger("data1.4096");
        Integer b8192[]=Reader.readToInteger("data1.8192");
        Integer b16384[]=Reader.readToInteger("data1.16384");
        Integer b32768[]=Reader.readToInteger("data1.32768");

        long start,end;

        System.out.println("Basic MergeSort:");
        System.out.println("DataSet\t\tNumberOfComparisons\t\tRuntime");

        start = System.currentTimeMillis();
        System.out.print("0.1024:\t\t"+Merge_Basic.sort(a1024));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.2048:\t\t"+Merge_Basic.sort(a2048));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.4096:\t\t"+Merge_Basic.sort(a4096));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.8192:\t\t"+Merge_Basic.sort(a8192));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.16384:\t"+Merge_Basic.sort(a16384));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.32768:\t"+Merge_Basic.sort(a32768));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        System.out.println();

        System.out.println("DataSet\t\tNumberOfComparisons\t\tRuntime");

        start = System.currentTimeMillis();
        System.out.print("1.1024:\t\t"+Merge_Basic.sort(b1024));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.2048:\t\t"+Merge_Basic.sort(b2048));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.4096:\t\t"+Merge_Basic.sort(b4096));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.8192:\t\t"+Merge_Basic.sort(b8192));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.16384:\t"+Merge_Basic.sort(b16384));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.32768:\t"+Merge_Basic.sort(b32768));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");


        System.out.println();

        System.out.println("QuickSort using Median-of-three:");
        System.out.println("DataSet\t\tNumberOfComparisons\t\tRuntime");

        start = System.currentTimeMillis();
        System.out.print("0.1024:\t\t"+Quick_MedianOf3.sort(a1024));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.2048:\t\t"+Quick_MedianOf3.sort(a2048));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.4096:\t\t"+Quick_MedianOf3.sort(a4096));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.8192:\t\t"+Quick_MedianOf3.sort(a8192));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.16384:\t"+Quick_MedianOf3.sort(a16384));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("0.32768:\t"+Quick_MedianOf3.sort(a32768));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        System.out.println();
        System.out.println("DataSet\t\tNumberOfComparisons\t\tRuntime");

        start = System.currentTimeMillis();
        System.out.print("1.1024:\t\t"+Quick_MedianOf3.sort(b1024));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.2048:\t\t"+Quick_MedianOf3.sort(b2048));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.4096:\t\t"+Quick_MedianOf3.sort(b4096));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.8192:\t\t"+Quick_MedianOf3.sort(b8192));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.16384:\t"+Quick_MedianOf3.sort(b16384));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.print("1.32768:\t"+Quick_MedianOf3.sort(b32768));
        end = System.currentTimeMillis();
        System.out.println("\t\t\t\t\t"+(end - start) + "(ms)");

        System.out.println();

        for (int i=0;i<21;i++) {
            System.out.println("MergeSort Cutoff="+i);
            Merge_Cutoff.setCutoff(i);
            System.out.println("DataSet\t\tNumberOfComparisons\t\tRuntime");

            start = System.currentTimeMillis();
            System.out.print("0.32768:\t" + Merge_Cutoff.sort(a32768));
            end = System.currentTimeMillis();
            System.out.println("\t\t\t\t\t" + (end - start) + "(ms)");

            start = System.currentTimeMillis();
            System.out.print("1.32768:\t" + Merge_Cutoff.sort(b32768));
            end = System.currentTimeMillis();
            System.out.println("\t\t\t\t\t" + (end - start) + "(ms)");

            System.out.println("QuickSort Cutoff="+i);
            Quick_Cutoff.setCutoff(i);
            System.out.println("DataSet\t\tNumberOfComparisons\t\tRuntime");

            start = System.currentTimeMillis();
            System.out.print("0.32768:\t" + Quick_Cutoff.sort(a32768));
            end = System.currentTimeMillis();
            System.out.println("\t\t\t\t\t" + (end - start) + "(ms)");

            start = System.currentTimeMillis();
            System.out.print("1.32768:\t" + Quick_Cutoff.sort(b32768));
            end = System.currentTimeMillis();
            System.out.println("\t\t\t\t\t" + (end - start) + "(ms)");
            System.out.println();
        }
    }
}
