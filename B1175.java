import java.util.*;

public class B1175 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Stack<Long> prev = new Stack<>();
        Stack<Long> end = new Stack<>();
        Stack<Long> waiting = new Stack<>();
        long run_ans = 0L;
        int forCt = 0;
        long MAX = ((long) Math.pow(2,32)) - 1;
        boolean flag = false;
        while(n-->0) {
            String cmd = in.nextLine();
            if( cmd.equals("add") ) {
                run_ans++;
                // System.out.println(run_ans);
            } else if( cmd.equals("end") ) {
                run_ans *= waiting.pop();
                if( !prev.isEmpty() ) run_ans += prev.pop();
                forCt--;
                if( forCt == 0 ) {
                    end.push(run_ans);
                    run_ans = 0;
                }
            } else {
                if( forCt > 0 ) prev.push(run_ans);
                else end.push(run_ans);
                waiting.push(Long.parseLong(cmd.split(" ")[1]));
                run_ans = 0;
                forCt++;
            }
            if( run_ans > MAX ) {
                flag = true; break;
            }
        }
        while(!end.isEmpty()) {
            run_ans += end.pop();
            if( run_ans > MAX ) {
                flag = true; break;
            }
        }
        if( flag ) System.out.println("OVERFLOW!!!"); 
        else System.out.println(run_ans);
    }
}