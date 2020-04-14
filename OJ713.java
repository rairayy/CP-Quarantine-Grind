import java.util.*;
import java.io.*;
public class OJ713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-->0) {
            String[] ary = br.readLine().split(" ");
            int len = Math.max(ary[0].length(),ary[1].length());
            int[] a = new int[len];
            int[] b = new int[len];
            for( int i = 0; i < ary[0].length(); i++ ) a[i] = Integer.parseInt(""+ary[0].charAt(i));
            for( int i = 0; i < ary[1].length(); i++ ) b[i] = Integer.parseInt(""+ary[1].charAt(i));
            int[] sum = new int[len+1];
            for( int i = 0; i < len; i++ ) {
                if( sum[i]+a[i]+b[i] > 9 ) sum[i+1]++;
                sum[i] = (sum[i]+a[i]+b[i])%10;
            }
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < len+1; i++ ) {
                if( i == len && sum[i] == 0 ) continue;
                sb.append(sum[i]);
            }
            String ans = sb.toString().replaceAll("^[0]*","");
            System.out.println(ans);
        }
    }
}