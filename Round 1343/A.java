import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0) {
            int x = in.nextInt();
            int i = 3;
            int bit = 2;
            while( x%i != 0 ) {
                bit <<= 1;
                i+=bit;
            }
            System.out.println((int)x/i);
        }
    }
}