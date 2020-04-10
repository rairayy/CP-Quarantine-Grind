import java.util.*;

public class B102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        int ct = 0;
        while(num.length()>1) {
            long sum = 0;
            for( int i = 0; i < num.length(); i++ ) sum += Long.parseLong(""+num.charAt(i));
            num = sum + "";
            ct++;
        }
        System.out.println(ct);
    }
}