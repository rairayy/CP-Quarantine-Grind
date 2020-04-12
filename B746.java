import java.util.*;

public class B746 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        String s = in.nextLine();
        StringBuilder L = new StringBuilder(), R = new StringBuilder();
        if( n%2 == 0 ) {
            for( int i = 0; i < n; i++ ) {
                if( i%2 == 0 ) L.append(s.charAt(i));
                else R.append(s.charAt(i));
            }
        } else {
            L.append(s.charAt(0));
            for( int i = 1; i < n; i++ ) {
                if( i%2 == 0 ) R.append(s.charAt(i));
                else L.append(s.charAt(i));
            }
        }
        System.out.println(L.reverse().toString()+R.toString());
    }
}