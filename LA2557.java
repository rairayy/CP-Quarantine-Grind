import java.util.*;

public class LA2557 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for( int i = 0; i < n; i++ ) {
            int x = in.nextInt();
            System.out.println((int)Math.floor(Math.sqrt(x)));
        }
    }
}

// import math as m
// n = int(input())
// for i in range(n):
//     x = int(input())
//     print(m.floor(m.sqrt(x)))