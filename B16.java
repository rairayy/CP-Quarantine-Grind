import java.util.*;

public class B16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Container[] ary = new Container[m];
        for( int i = 0; i < m; i++ ) ary[i] = new Container(in.nextInt(), in.nextInt());
        Arrays.sort(ary);
        // for( Container c : ary ) c.print();
        int amt = 0;
        for( Container c : ary ) {
            if( c.boxes < n ) {
                amt += c.boxes*c.matches;
                n-=c.boxes;
            } else {
                amt += c.matches*n;
                break;
            }
        }
        System.out.println(amt);
    }
    public static class Container implements Comparable<Container> {
        int boxes, matches;
        public Container( int boxes, int matches ) {
            this.boxes = boxes;
            this.matches = matches;
        }
        public int compareTo( Container c ) {
            return c.matches-matches;
        }
        public void print() {
            System.out.printf("%d %d\n",boxes, matches);
        }
    }
}