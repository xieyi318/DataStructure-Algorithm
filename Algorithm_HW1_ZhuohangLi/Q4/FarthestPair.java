
public class FarthestPair {
	//takes an given array, returns an array of two element
	public static double[] findFarthestPair(double a[]) {
		double max=a[0];
		double min=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) max=a[i];
			if(a[i]<min) min=a[i];
		}
		double pair[]= {max,min};
		return pair;
	}
	
	public static void main(String[] args) {
		double a[]=new double[args.length];
		for(int i=0;i<args.length;i++) {
			a[i]=Double.valueOf(args[i]);
		}
		double pair[]=findFarthestPair(a);
		for(int i=0;i<pair.length;i++) {
			System.out.println(pair[i]);
		}
	}
}
