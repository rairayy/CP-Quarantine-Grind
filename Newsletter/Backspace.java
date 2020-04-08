import java.util.*;

public class Backspace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String m = in.nextLine();
        System.out.println(compareWithBackspace(n,m));
    }
    static boolean compareWithBackspace( String n, String m ) {
        String a = getString(n), b = getString(m);
        // System.out.printf("%s %s\n",a,b);
        if( a.equals(b) ) return true;
        return false;
    }
    static String getString( String s ) {
        StringBuilder sb = new StringBuilder();
        int hashCount = 0; // track number of #
        // start from end of string
        for( int i = s.length()-1; i >= 0; i-- ) {
            if( s.charAt(i) == '#' ) {
                hashCount++;
            } else {
                if( hashCount > 0 ) hashCount--;
                else sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}