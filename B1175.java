import java.util.*;

public class B1175 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Stack<Long> ans = new Stack<>();
        Stack<Long> waiting = new Stack<>();
        long run_ans = 0L;
        while(n-->0) {
            String cmd = in.nextLine();
            if( cmd.equals("add") ) run_ans++;
            else if( cmd.equals("end") ) {
                run_ans *= waiting.pop();
                if( run_ans > Integer.MAX_VALUE ) {
                    run_ans = -1; break;
                }
            } else {
                String[] gvn = cmd.split(" ");
                ans.push(run_ans);
                run_ans = 0;
                waiting.push(Long.parseLong(gvn[1]));
            }
            System.out.printf("%s %d\n", cmd, run_ans);
        }
        while(!ans.isEmpty()) {
            run_ans += ans.pop();
            if( run_ans > Integer.MAX_VALUE ) {
                run_ans = -1; break;
            }
        }
        if( run_ans == -1 ) System.out.println("OVERFLOW!!!"); 
        else System.out.println(run_ans);
    }
}