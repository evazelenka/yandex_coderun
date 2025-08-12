import java.io.*;
import java.util.*;

public class NumbersAndKostya {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Long> gains = new ArrayList<>(n * 10);

        for (int i = 0; i < n; i++) {
            String numStr = st.nextToken(); // читаем как строку, чтобы обрабатывать каждую цифру
            int len = numStr.length();
            for (int pos = 0; pos < len; pos++) {
                int digit = numStr.charAt(pos) - '0';
                if (digit < 9) { // только если есть выгода
                    long weight = 1;
                    for (int w = 0; w < len - pos - 1; w++) {
                        weight *= 10;
                    }
                    long gain = (9 - digit) * weight;
                    gains.add(gain);
                }
            }
        }

        // Сортируем по убыванию
        gains.sort(Collections.reverseOrder());

        // Берём k наибольших прибавок
        long result = 0;
        for (int i = 0; i < Math.min(k, gains.size()); i++) {
            result += gains.get(i);
        }

        System.out.println(result);
    }
}
