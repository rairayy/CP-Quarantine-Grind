import java.util.*;
import java.io.*;

public class I {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			String[] input = br.readLine().split(" ");
			long d = Long.parseLong(input[2]);
			pw.printf("%.7f\n",(d*d)/2.0);
		}
		pw.flush();
		br.close();
		pw.close();
	}
}