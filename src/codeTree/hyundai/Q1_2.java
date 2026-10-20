package codeTree.hyundai;

import java.util.*;

public class Q1_2 {
    static int[] dRow = {-1, 0, 1, 0}; // 북, 서, 남, 동
    static int[] dCol = {0, -1, 0, 1};
    static char[] directions = {'^', '<', 'v', '>'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        char[][] grid = new char[H][W];
        int total = 0;

        for (int i = 0; i < H; i++) {
            String line = sc.next();

            for (int j = 0; j < W; j++) {
                grid[i][j] = line.charAt(j);

                if (grid[i][j] == '#') {
                    total++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answerR = 0, answerC = 0;
        char answerD = ' ';
        String answerI = "";

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                if (grid[i][j] == '#') {
                    int count = 0;
                    int startD = -1;

                    // 주변에 연결된 # 개수 확인
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dRow[d];
                        int nc = j + dCol[d];

                        if (nr >= 0 && nr < H && nc >= 0 && nc < W
                                && grid[nr][nc] == '#') {
                            count++;
                            startD = d;
                        }
                    }

                    // 끝점인 경우에만 시작
                    if (count == 1) {
                        boolean[][] visited = new boolean[H][W];
                        visited[i][j] = true;

                        int row = i;
                        int col = j;
                        int direction = startD;
                        int visitedCount = 1;

                        StringBuilder instruction = new StringBuilder();

                        while (visitedCount < total) {
                            int nextD = -1;

                            // 다음 이동 방향 찾기
                            for (int d = 0; d < 4; d++) {
                                int nr = row + dRow[d];
                                int nc = col + dCol[d];

                                if (nr >= 0 && nr < H && nc >= 0 && nc < W
                                        && grid[nr][nc] == '#'
                                        && !visited[nr][nc]) {
                                    nextD = d;
                                    break;
                                }
                            }

                            if (nextD == -1) {
                                break;
                            }

                            // 왼쪽 회전
                            if (nextD == (direction + 1) % 4) {
                                instruction.append('L');
                            }
                            // 오른쪽 회전
                            else if (nextD == (direction + 3) % 4) {
                                instruction.append('R');
                            }

                            direction = nextD;

                            // A: 두 칸 전진
                            boolean possible = true;

                            for (int k = 0; k < 2; k++) {
                                int nr = row + dRow[direction];
                                int nc = col + dCol[direction];

                                if (nr >= 0 && nr < H && nc >= 0 && nc < W
                                        && grid[nr][nc] == '#'
                                        && !visited[nr][nc]) {
                                    row = nr;
                                    col = nc;
                                    visited[row][col] = true;
                                    visitedCount++;
                                } else {
                                    possible = false;
                                    break;
                                }
                            }

                            if (possible) {
                                instruction.append('A');
                            } else {
                                break;
                            }
                        }

                        // 모든 #을 방문한 경우 정답 갱신
                        if (visitedCount == total &&
                                instruction.length() <= min) {

                            min = instruction.length();
                            answerR = i;
                            answerC = j;
                            answerD = directions[startD];
                            answerI = instruction.toString();
                        }
                    }
                }
            }
        }

        System.out.println((answerR + 1) + " " + (answerC + 1));
        System.out.println(answerD);
        System.out.println(answerI);
    }
}