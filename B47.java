import java.util.*;

public class B47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pair[] ary = new Pair[3];
        for( int i = 0; i < 3; i++ ) ary[i] = new Pair(""+(char)('A'+i),0);
        for( int i = 0; i < 3; i++ ) {
            char[] line = in.nextLine().toCharArray();
            if( line[1] == '>' ) {
                ary[line[0]-'A'].val++;
            } else {
                ary[line[2]-'A'].val++;
            }
        }
        Arrays.sort(ary);
        boolean flag = false;
        for( int i = 0; i < 2; i++ ) {
            if( ary[i].val == ary[i+1].val ) {
                flag = true; break;
            }
        }
        if(flag) System.out.println("Impossible");
        else {
            for( Pair p : ary ) System.out.print(p.letter);
            System.out.println();
        }
    }
    static class Pair implements Comparable<Pair> {
        String letter;
        int val;
        public Pair( String letter, int val ) {
            this.letter = letter;
            this.val = val;
        }
        public int compareTo(Pair p) {
            return val-p.val;
        }
    }
}