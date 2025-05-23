import java.io.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Queue;

class Person {
    int r;
    int c;
    int stage;

    public Person(int r, int c, int stage) {
        this.r = r;
        this.c = c;
        this.stage = stage;
    }
}

class Fire {
    int r;
    int c;
    int stage;

    public Fire(int r, int c, int stage) {
        this.r = r;
        this.c = c;
        this.stage = stage;
    }
}

public class Problem4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line;
        int stage = 1;

        Integer minStage = null;
        int nextR;
        int nextC;

        int[] DR = { 0, 1, 0, -1};
        int[] DC = { 1, 0, -1, 0};

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[r][c];

        Queue<Person> p = new LinkedList<>();
        Queue<Fire> f = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            line = br.readLine();
            for (int j = 0; j < c; j++) {
                switch (line.charAt(j)) {
                    case '#':
                        visited[i][j] = true;
                        break;

                    case 'F':
                        visited[i][j] = true;
                        f.add(new Fire(i, j, stage));
                        break;

                    case 'J':
                        visited[i][j] = true;
                        p.add(new Person(i, j, stage));
                        break;

                    default:
                        visited[i][j] = false;
                        break;
                }
            }
        }

        // 미로 탈출
        // While PersonQueue가 is null이 아닐때까지
        // F를 remove하고
        // 4번의 반복
        // 만약 visited[][] 값이 False면 True로 바꾸고 FireQueue에 push

        // J를 remove하고
        // 4번 반복
        // 만약 visited[][] 값이 False면 True로 바꾸고 PersonQueue에 push

        // J를 remove한 값의 x가 0 or R  혹은 y가 0 or C인지 확인
        // 맞다면 몇번째 단계인지 min-stage와 비교 후 작으면 값 변경

        while (!p.isEmpty()) {
            stage++;

            if (!f.isEmpty()) {
                Fire fire = f.peek();

                while (!f.isEmpty()&& fire.stage == stage-1) {
                    fire = f.remove();
                    for (int i = 0; i < 4; i++) {
                        nextR = fire.r + DR[i];
                        nextC = fire.c + DC[i];
                        if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c) {
                            if (!visited[nextR][nextC]) {
                                visited[nextR][nextC] = true;
                                f.add(new Fire(nextR, nextC, stage));
                            }
                        }
                    }
                    fire = f.peek();
                }
            }

            Person person = p.peek();

            while (person != null && person.stage == stage - 1) {
                person = p.remove();
                for (int i = 0; i < 4; i++) {
                    nextR = person.r + DR[i];
                    nextC = person.c + DC[i];
                    if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c) {
                        if (!visited[nextR][nextC]) {
                            visited[nextR][nextC] = true;
                            p.add(new Person(nextR, nextC, stage));
                        }
                    }
                }




                if (person.r == 0 || person.r == r-1 || person.c == 0 || person.c == c-1) {
                    if (minStage == null || minStage > person.stage) {
                        minStage = person.stage;
                    }
                }

                person = p.peek();
            }
        }
        if (minStage != null) {
            bw.write(String.valueOf(minStage));
        }
        else {
            bw.write("IMPOSSIBLE");
        }


        bw.flush();
        bw.close();
    }
}