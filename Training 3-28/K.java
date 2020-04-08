import java.util.*;
import java.io.*;
public class K {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int Q = Integer.parseInt(br.readLine());
			while(Q-->0) {
				HashMap<String,String> hm = new HashMap<>();
				for( int i = 0; i < 10; i++ ) {
					String line = br.readLine();
					if( line.equals("@article{") || line.equals("}") ) {
						continue;
					} else {
						String line2 = line.replaceAll("},","");
						String line3 = line2.replaceAll("[{}]","");
						String[] temp = line3.split("=");
						hm.put(temp[0],temp[1]);
					}
				}
				StringBuilder ans = new StringBuilder();
				StringBuilder sb = new StringBuilder();
				String[] authors = hm.get("author").split(",");
				for( String a : authors ) {
					String[] name = a.split(" ");
					if( name[0].length() == 0 ) {
						sb.append(name[1].substring(0,2)+". "+name[2].substring(0,1)+", ");
					} else {
						sb.append(name[0].substring(0,2)+". "+name[1].substring(0,1)+", ");
					}
				}
				ans.append(sb.toString().substring(0,sb.length()-2)+". ");
				ans.append(hm.get("title")+". ");
				ans.append(hm.get("journal")+". ");
				ans.append(hm.get("year")+";");
				ans.append(hm.get("volume")+"(");
				ans.append(hm.get("number")+"):");
				ans.append(hm.get("pages")+".");
				pw.println(ans);
			}
		}
		pw.flush();
		br.close();
		pw.close();
	}
}