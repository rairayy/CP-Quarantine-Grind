import java.util.*;

public class B78 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] colors = {"R","O","Y"};
        String[] append = {"G","B","I","V"};
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        while(n-->0) {
            sb.append(colors[ind]);
            ind++;
            if( ind > 2 ) break;
        }
        ind = 0;
        while(n-->0) {
            sb.append(append[ind]);
            ind++;
            ind%=4;
        }
        System.out.println(sb.toString());
    }
}