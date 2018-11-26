public class Q4 {
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


        System.out.println("Basic MergeSort:");
        System.out.println("DataSet\t\tNumberOfComparisons");
        System.out.println("0.1024:\t\t"+Merge_Basic.sort(a1024));
        System.out.println("0.2048:\t\t"+Merge_Basic.sort(a2048));
        System.out.println("0.4096:\t\t"+Merge_Basic.sort(a4096));
        System.out.println("0.8192:\t\t"+Merge_Basic.sort(a8192));
        System.out.println("0.16384:\t"+Merge_Basic.sort(a16384));
        System.out.println("0.32768:\t"+Merge_Basic.sort(a32768));
        System.out.println();
        System.out.println("DataSet NumberOfComparisons");
        System.out.println("1.1024:\t\t"+Merge_Basic.sort(b1024));
        System.out.println("1.2048:\t\t"+Merge_Basic.sort(b2048));
        System.out.println("1.4096:\t\t"+Merge_Basic.sort(b4096));
        System.out.println("1.8192:\t\t"+Merge_Basic.sort(b8192));
        System.out.println("1.16384:\t"+Merge_Basic.sort(b16384));
        System.out.println("1.32768:\t"+Merge_Basic.sort(b32768));
        System.out.println();

        System.out.println("BottomUp MergeSort:");
        System.out.println("DataSet\t\tNumberOfComparisons");
        System.out.println("0.1024:\t\t"+Merge_BottomUp.sort(a1024));
        System.out.println("0.2048:\t\t"+Merge_BottomUp.sort(a2048));
        System.out.println("0.4096:\t\t"+Merge_BottomUp.sort(a4096));
        System.out.println("0.8192:\t\t"+Merge_BottomUp.sort(a8192));
        System.out.println("0.16384:\t"+Merge_BottomUp.sort(a16384));
        System.out.println("0.32768:\t"+Merge_BottomUp.sort(a32768));
        System.out.println();
        System.out.println("DataSet\t\tNumberOfComparisons");
        System.out.println("1.1024:\t\t"+Merge_BottomUp.sort(b1024));
        System.out.println("1.2048:\t\t"+Merge_BottomUp.sort(b2048));
        System.out.println("1.4096:\t\t"+Merge_BottomUp.sort(b4096));
        System.out.println("1.8192:\t\t"+Merge_BottomUp.sort(b8192));
        System.out.println("1.16384:\t"+Merge_BottomUp.sort(b16384));
        System.out.println("1.32768:\t"+Merge_BottomUp.sort(b32768));
    }
}
