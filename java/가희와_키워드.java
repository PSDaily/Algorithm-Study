import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와_키워드{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> memo_keywords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            memo_keywords.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer keywords = new StringTokenizer(br.readLine(), ",");
            while (keywords.hasMoreTokens()) {
                String keyword = keywords.nextToken();
                memo_keywords.remove(keyword);
            }
            bw.write(memo_keywords.size() + "\n");
        }
        bw.flush();
        
    }
}