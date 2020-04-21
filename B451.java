import java.util.*;

public class B451 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ary = new int[n];
        for( int i = 0; i < n; i++ ) ary[i] = in.nextInt();
        int start = -1, end = -1;
        for( int i = 0; i < n-1; i++ ) {
            if(start == -1 && ary[i] > ary[i+1]) start = i;
            else if( end == -1 && start != -1 && ary[i] < ary[i+1]) end = i;
        }
        if( start == -1 ) {
            System.out.println("yes");
            System.out.println("1 1");
        } else {
            if( end == -1 ) end = n-1;
            int[] sorty = ary.clone();
            for( int i = 0; i <= end-start; i++ ) {
                sorty[start+i] = ary[end-i];
            }
            Arrays.sort(ary);
            boolean sorted = true;
            for( int i = 0; i < n; i++ ) {
                if( ary[i] != sorty[i] ) {
                    sorted = false;
                    break;
                }
            }
            if( sorted ) {
                System.out.println("yes");
                System.out.printf("%d %d\n",start+1,end+1);
            } else System.out.println("no");
        }
    }
}