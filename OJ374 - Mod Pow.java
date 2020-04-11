import java.util.*;

public class OJ374 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            long B = Long.parseLong(in.nextLine());
            long P = Long.parseLong(in.nextLine());
            long M = Long.parseLong(in.nextLine());
            System.out.println(modPow(B,P,M));
            if(in.hasNext()) in.nextLine();
        }
    }
    public static long modPow( long B, long P, long M ) {
        if( P == 0 ) return 1;
        long C = modPow(B,(long)P/2,M);
        C = (C*C)%M;
        if( P%2 == 0 ) return C;
        else return (C*B)%M;
    }
}