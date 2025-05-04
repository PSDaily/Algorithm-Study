import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x;
    int y;
    int day;

    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class Problem7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int [][] box = new int[x][y];
        int count = 0;
        int day = 0;

        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 0){
                    count++;
                }

                if (box[i][j] == 1){
                    queue.add(new Tomato(i, j, day));
                }
            }
        }

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            if(tomato.day == day){
                day++;
            }

            if(tomato.x >= 1 && box[tomato.x-1][tomato.y] == 0){
                count--;
                box[tomato.x-1][tomato.y] = 1;
                queue.add(new Tomato(tomato.x-1, tomato.y, day));
            }

            if(tomato.y >= 1 && box[tomato.x][tomato.y-1] == 0){
                count--;
                box[tomato.x][tomato.y-1] = 1;
                queue.add(new Tomato(tomato.x, tomato.y-1,  day));
            }

            if(tomato.x < x-1 && box[tomato.x+1][tomato.y] == 0){
                count--;
                box[tomato.x+1][tomato.y] = 1;
                queue.add(new Tomato(tomato.x+1, tomato.y, day));
            }
            if(tomato.y < y-1 && box[tomato.x][tomato.y+1] == 0){
                count--;
                box[tomato.x][tomato.y+1] = 1;
                queue.add(new Tomato(tomato.x,tomato.y+1,  day));
            }



        }

        if(count == 0){
            bw.write(String.valueOf(day-1));
        }
        else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();



    }
}