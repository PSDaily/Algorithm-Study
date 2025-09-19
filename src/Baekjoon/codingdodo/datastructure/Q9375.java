package Baekjoon.codingdodo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Map<String, List<String>> clothes = new HashMap<> ();

            int n = Integer.parseInt(br.readLine());

            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String type = st.nextToken();

                // System.out.println("name: " + name + ", type: " + type);

                clothes.putIfAbsent(type, new ArrayList<>());
                clothes.get(type).add(name);
            }

            // System.out.println(clothes);

            int num = 1;
            for(String type : clothes.keySet()) {
                num *= clothes.get(type).size()+1;
            }

            System.out.println(num-1);

        }

    }
}

