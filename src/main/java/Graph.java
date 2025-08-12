import java.io.*;
import java.util.*;

public class Graph {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int peaks = Integer.parseInt(str[0]);
        int ribs = Integer.parseInt(str[1]);
        Map<Integer, List<Integer>> ribMap = new HashMap<>();
        for (int i = 0; i < ribs; i++) {
            String[] strings = reader.readLine().split(" ");
            int f = Integer.parseInt(strings[0]);
            int s = Integer.parseInt(strings[1]);
            if (f != s){
                ribMap.computeIfAbsent(f, v -> new ArrayList<>()).add(s);
                ribMap.computeIfAbsent(s, v -> new ArrayList<>()).add(f);
            }
        }
        boolean[] visited = dfs(peaks, ribMap);
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < visited.length; j++) {
            if (visited[j]){
                result.add(j);
            }
        }
        System.out.println(result.size());
        for (int j = 0; j < result.size(); j++) {
            System.out.print(result.get(j) + " ");
        }

        reader.close();
        writer.close();
    }

    public static boolean[] dfs(int peaks, Map<Integer, List<Integer>> ribMap){
        boolean[] visited = new boolean[peaks+1];
        List<Integer> one = ribMap.get(1);
        visited[1] = true;
        if (one == null) return visited;
        stepDfs(ribMap, one, visited);
        return visited;
    }

    private static void stepDfs(Map<Integer, List<Integer>> ribMap, List<Integer> one, boolean[] visited) {
        for (int i : one) {
            if (!visited[i]){
                visited[i] = true;
                stepDfs(ribMap, ribMap.get(i), visited);
            }
        }
    }
}
