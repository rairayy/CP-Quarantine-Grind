import java.util.*;
import java.io.*;
public class K2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            String[] given = br.readLine().split(" ");
            int n = Integer.parseInt(given[0]);
            int m = Integer.parseInt(given[1]);
            int k = Integer.parseInt(given[2]);
            Submission[] subs = new Submission[k];
            for( int i = 0; i < k; i++ ) {
                subs[i] = new Submission(br.readLine().split(" "));
            }
            Arrays.sort(subs); // sort by submission time
            
            int[] problems = new int[n]; // get first to solves
            Arrays.fill(problems,-1);
            for( Submission s : subs ) {
                if( s.ac == 1 && problems[s.id] == -1 ) problems[s.id] = s.student+1;
            }
            
            int extreme = -1;
            for( Submission s : subs ) {
                if( s.ac == 1 ) {
                    extreme = s.student+1; break;
                }
            }

            int steadfast = -1;
            for( int i = k-1; i >= 0; i-- ) {
                if( subs[i].ac == 1 ) {
                    steadfast = subs[i].student+1; break;
                }
            }

            int[][] ary = new int[m][n];
            int[][] ac_ary = new int[m][n];
            for( int[] probs : ary ) Arrays.fill(probs,-1);
            
            for( Submission s : subs ) {
                ary[s.student][s.id]++;
                if( s.ac == 1 ) ac_ary[s.student][s.id] = 1;
            }

            // for( int[] a : ary ) System.out.println(Arrays.toString(a));

            int solid = -1, relentless = -1;
            int max = Integer.MIN_VALUE, max_r = Integer.MIN_VALUE;
            for( int i = 0; i < m; i++ ) {
                int ct = 0;
                for( int j = 0; j < n; j++ ) {
                    if( ac_ary[i][j] == 1 && ary[i][j] == 0 ) ct++;
                    if( ac_ary[i][j] == 1 && ary[i][j] > max_r ) {
                        relentless = i;
                        max_r = ary[i][j];
                    } 
                }
                if( ct > max ) {
                    solid = i;
                    max = ct;
                }
            }
            for( int i : problems ) System.out.print(i+" ");
            System.out.println();
            System.out.printf("%d %d %d %d\n", extreme, steadfast, solid+1, relentless+1);
        }
    }
    public static class Submission implements Comparable<Submission>{
        int id, student, ac, min, sec;
        public Submission(String[] given) {
            id = Integer.parseInt(given[0])-1;
            student = Integer.parseInt(given[1])-1;
            ac = Integer.parseInt(given[2]);
            String[] time = given[3].split(":");
            min = Integer.parseInt(time[0]);
            sec = Integer.parseInt(time[1]);
        }
        public int compareTo( Submission s ) {
            if( min == s.min ) return sec - s.sec;
            return min - s.min;
        }
        public void print() {
            System.out.printf("%d %d %d %d:%d\n",id, student, ac, min, sec);
        }
    }
}