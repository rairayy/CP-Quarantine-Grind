import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            String[] temp = br.readLine().split(" ");
            int Q = Integer.parseInt(temp[1]);
            HashMap<String,Integer> hm = new HashMap<>();
            String[] array = br.readLine().split(" ");
            // put stuff in hm
            for( String s : array ) hm.put(s,hm.getOrDefault(s,0)+1);
            while(Q-->0) {
                temp = br.readLine().split(" ");
                int op = Integer.parseInt(temp[0]);
                if( op == 1 ) {
                    int ind = Integer.parseInt(temp[1])-1;
                    // reduce count of current value
                    String replace = array[ind];
                    if( hm.get(replace) == 1 ) hm.remove(replace);
                    else hm.put(replace,hm.get(replace)-1);
                    // add new value
                    String replace_with = temp[2];
                    if(!replace_with.equals("0")) hm.put(replace_with,hm.getOrDefault(replace_with,0)+1);
                    // replace new value in the array
                    array[ind] = replace_with;
                } else pw.println(hm.size());
            }
        }
        pw.close();
        br.close();
    }
}