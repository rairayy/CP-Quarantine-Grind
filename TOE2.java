import java.util.*;
import java.io.*;
public class TOE2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashSet<String> hs = new HashSet<>();
        StringBuilder init = new StringBuilder(".........");
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(init,'X'));
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            StringBuilder b = curr.board;
            hs.add(b.toString());
            char turn = curr.turn;
            if(winning(b)) continue;
            for( int i = 0; i < 9; i++ ) {
                if( c(b,i) == '.' ) {
                    char t = 'X';
                    if( turn == 'X') t = 'O';
                    b.replace(i, i+1, turn+"");
                    q.add(new Pair(new StringBuilder(b.toString()),t));
                    b.replace(i, i+1, ".");
                }
            }  
        }
        // Iterator it = hs.iterator();
        // while(it.hasNext()) System.out.println(it.next());
        while(true) {
            StringBuilder board = new StringBuilder(br.readLine());
            if(board.toString().equals("end")) break;
            // System.out.println(board);
            String ans = "invalid";
            if(hs.contains(board.toString())&&(winning(board)||full(board))) ans = "valid";
            pw.println(ans);
        }
        pw.close();
    }
    static boolean full(StringBuilder board) {
        return c(board,0) != '.' && c(board,1) != '.' && c(board,2) != '.' && c(board,3) != '.' && c(board,4) != '.' && c(board,5) != '.' && c(board,6) != '.' && c(board,7) != '.' && c(board,8) != '.';
    }
    static char c(StringBuilder board,int i) {
        return board.toString().charAt(i);
    }
    static boolean equal(StringBuilder board, int a, int b, int c) {
        return c(board,a) != '.' && c(board,a) == c(board,b) && c(board,c) == c(board, b);
    }
    static boolean winning(StringBuilder board) {
        return  equal(board, 0, 1, 2) || equal(board, 3, 4, 5) || equal(board, 6, 7, 8) ||
                equal(board, 0, 3, 6) || equal(board, 1, 4, 7) || equal(board, 2, 5, 8) ||
                equal(board, 0, 4, 8) || equal(board, 2, 4, 6);
    }
    static class Pair {
        StringBuilder board; char turn;
        public Pair( StringBuilder board, char turn ) {
            this.board = board;
            this.turn = turn;
        } 
    }
}