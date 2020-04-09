import java.util.*;
import java.text.*;

public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		double ans = 0.0;
		// goat pole between x1 and x2 (above/below)
		if (x>=Math.min(x1,x2) && x<=Math.max(x1,x2)) {
			ans = Math.min(Math.abs(y-y1),Math.abs(y-y2));
		} else if (y>=Math.min(y1,y2) && y<=Math.max(y1,y2)) {
			ans = Math.min(Math.abs(x-x1),Math.abs(x-x2));
		} else {
			if( y>=Math.max(y1,y2) ) { // upper
				if( x<=Math.min(x1,x2) ) { // left corner
					ans = sr(pow(x-min(x1,x2))+pow(y-max(y1,y2)));
				} else {
					ans = sr(pow(x-max(x1,x2))+pow(y-max(y1,y2)));
				}
			} else { // lower
				if( x<=Math.min(x1,x2) ) { // left corner
					ans = sr(pow(x-min(x1,x2))+pow(y-min(y1,y2)));
				} else {
					ans = sr(pow(x-max(x1,x2))+pow(y-min(y1,y2)));
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#.000");
		System.out.println(df.format(ans));
	}
	static int pow(int n) {
		return n*n;
	}
	static double sr(int n) {
		return Math.sqrt(n);
	}
	static int max(int a, int b) {
		return Math.max(a,b);
	}
	static int min( int a, int b) {
		return Math.min(a,b);
	}
}