public class Q1 {
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


        System.out.println("InsertionSort:");
        System.out.println("DataSet\t\tNumberOfComparisons");
        System.out.println("0.1024:\t\t"+Insertion.sort(a1024));
        System.out.println("0.2048:\t\t"+Insertion.sort(a2048));
        System.out.println("0.4096:\t\t"+Insertion.sort(a4096));
        System.out.println("0.8192:\t\t"+Insertion.sort(a8192));
        System.out.println("0.16384:\t"+Insertion.sort(a16384));
        System.out.println("0.32768:\t"+Insertion.sort(a32768));
        System.out.println();
        System.out.println("DataSet NumberOfComparisons");
        System.out.println("1.1024:\t\t"+Insertion.sort(b1024));
        System.out.println("1.2048:\t\t"+Insertion.sort(b2048));
        System.out.println("1.4096:\t\t"+Insertion.sort(b4096));
        System.out.println("1.8192:\t\t"+Insertion.sort(b8192));
        System.out.println("1.16384:\t"+Insertion.sort(b16384));
        System.out.println("1.32768:\t"+Insertion.sort(b32768));
        System.out.println();

        System.out.println("ShellSort:");
        System.out.println("DataSet\t\tNumberOfComparisons");
        System.out.println("0.1024:\t\t"+Shell.sort(a1024));
        System.out.println("0.2048:\t\t"+Shell.sort(a2048));
        System.out.println("0.4096:\t\t"+Shell.sort(a4096));
        System.out.println("0.8192:\t\t"+Shell.sort(a8192));
        System.out.println("0.16384:\t"+Shell.sort(a16384));
        System.out.println("0.32768:\t"+Shell.sort(a32768));
        System.out.println();
        System.out.println("DataSet\t\tNumberOfComparisons");
        System.out.println("1.1024:\t\t"+Shell.sort(b1024));
        System.out.println("1.2048:\t\t"+Shell.sort(b2048));
        System.out.println("1.4096:\t\t"+Shell.sort(b4096));
        System.out.println("1.8192:\t\t"+Shell.sort(b8192));
        System.out.println("1.16384:\t"+Shell.sort(b16384));
        System.out.println("1.32768:\t"+Shell.sort(b32768));
    }
}
