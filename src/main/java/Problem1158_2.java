import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1158_2 {
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        K = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(i+1);
        }

        //---
        int pos = 0;
        sb.append("<");
        while (numbers.size() > 0) {
            pos += K;
            pos = normalizeOverIndex(pos, numbers);

            int num = numbers.remove(pos-1);

            print(numbers, sb, num);

            pos--;
        }

        System.out.println(sb);
    }

    private static void print(List<Integer> numbers, StringBuilder sb, int num) {
        if (numbers.size() == 0) {
            sb.append(num).append(">");
        } else {
            sb.append(num).append(", ");
        }
    }

    private static int normalizeOverIndex(int pos, List<Integer> numbers) {
        if (pos > numbers.size()) {
            pos %= numbers.size();
            if (pos == 0) {
                pos = numbers.size();
            }
        }
        return pos;
    }
}
