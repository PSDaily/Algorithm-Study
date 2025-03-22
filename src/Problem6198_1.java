import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Building {
    int start;
    int height;

    Building(int start, int height) {
        this.start = start;
        this.height = height;
    }
}

public class Problem6198_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Stack<Building> stack = new Stack<>();
        Building highest = null;

        long sum = 0;
        int height = Integer.parseInt(br.readLine());

        // 스택이 비어있으면 하나 채우고 맥스값 바꾸기
        Building building = new Building(1, height);
        stack.push(building);
        highest = stack.peek();

        for (int i = 1; i < count; i++) {
            height = Integer.parseInt(br.readLine());
            building = new Building(i+1, height);


            if (highest.height > building.height) {
                while (stack.peek().height <= building.height) {
                    sum += i - stack.pop().start;
                }
            }

            else {
                highest = building;
                while (!stack.isEmpty()) {
                    sum += i - stack.pop().start;
                }
            }

            stack.push(building);

        }

        stack.pop();
        while (!stack.isEmpty()) {
            sum += count - stack.pop().start;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}