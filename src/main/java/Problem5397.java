import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem5397 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            char[] line = br.readLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                char c = line[i];
                switch (c) {
                    case '<' :
                        if(iterator.hasPrevious()) iterator.previous();
                        break;
                    case '>':
                        if(iterator.hasNext()) iterator.next();
                        break;
                    case '-' :
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default:
                        iterator.add(c);
                        break;
                }
            }
                /*switch (c) {
                    case '<' -> {
                        if(iterator.hasPrevious()) iterator.previous();
                    }
                    case '>' -> {
                        if(iterator.hasNext()) iterator.next();
                    }
                    case '-' -> {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                    }
                    default -> {
                        iterator.add(c);
                    }
                }*/
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
