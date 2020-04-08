import java.util.*;
import java.io.*;
public class A650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> X = new HashMap<>();
        HashMap<String, Integer> Y = new HashMap<>();
        HashSet<String> check = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int sub = 0;
        while(n-->0) {
            String line = br.readLine();
            if( check.contains(line) ) sub++;
            else check.add(line);
            String[] temp = line.split(" ");
            X.put(temp[0],X.getOrDefault(temp[0],0)+1);
            Y.put(temp[1],Y.getOrDefault(temp[1],0)+1);
        }
        long ans = 0;
        Iterator X_it = X.entrySet().iterator();
        while(X_it.hasNext()) {
            Map.Entry en = (Map.Entry) X_it.next();
            ans += chooseTwo((int)en.getValue());
            X_it.remove();
        }
        Iterator Y_it = Y.entrySet().iterator();
        while(Y_it.hasNext()) {
            Map.Entry en = (Map.Entry) Y_it.next();
            ans += chooseTwo((int)en.getValue());
            Y_it.remove();
        }
        System.out.println(ans-sub);
    }
    public static long chooseTwo(int x) {
        return (long) (x*(x-1))/2;
    }
}