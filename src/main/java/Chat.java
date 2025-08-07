import java.io.*;
import java.util.*;

public class Chat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // Храним события по id ракеты
        Map<Integer, List<Event>> logMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int day = Integer.parseInt(parts[0]);
            int hour = Integer.parseInt(parts[1]);
            int minute = Integer.parseInt(parts[2]);
            int id = Integer.parseInt(parts[3]);
            char status = parts[4].charAt(0);
            int time = day * 24 * 60 + hour * 60 + minute;
            logMap.computeIfAbsent(id, k -> new ArrayList<>()).add(new Event(time, status));
        }

        // Храним результат: id -> общее время
        Map<Integer, Integer> result = new TreeMap<>();

        for (var entry : logMap.entrySet()) {
            int id = entry.getKey();
            List<Event> events = entry.getValue();
            events.sort(Comparator.comparingInt(e -> e.time));
            int total = 0;

            for (int i = 0; i < events.size(); i++) {
                if (events.get(i).status == 'A') {
                    int start = events.get(i).time;
                    // ищем соответствующий C или S
                    int j = i + 1;
                    while (j < events.size() && events.get(j).status != 'C' && events.get(j).status != 'S') {
                        j++;
                    }
                    if (j < events.size()) {
                        total += events.get(j).time - start;
                        i = j; // переходим к следующему заказу
                    }
                }
            }
            result.put(id, total);
        }

        // Вывод результатов
        for (int time : result.values()) {
            System.out.print(time + " ");
        }
    }

    // Класс события
    static class Event {
        int time;
        char status;
        Event(int time, char status) {
            this.time = time;
            this.status = status;
        }
    }
}