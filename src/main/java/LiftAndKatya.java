/**
 * У Кати насыщенный день на работе. Ей надо передать n разных договоров коллегам. Все встре- чи происходят на разных этажах, а между этажами можно перемещаться только по лестничным пролетам — считается, что это улучшает физическую форму сотрудников. Прохождение каждого пролета занимает ровно  минуту.
 * Сейчас Катя на парковочном этаже, планирует свой маршрут. Коллег можно посетить в любом порядке, но один из них покинет офис через  минут. С парковочного этажа лестницы нет — только лифт, на котором можно подняться на любой этаж.
 *
 * В первой строке вводятся целые положительные числа  n и t — количество сотрудников и время, когда один из сотрудников покинет офис (в минутах). В следующей
 * строке n чисел — номера этажей, на которых находятся сотрудники. Все числа различны и по абсолютной величине не превосходят 100. Номера этажей даны в порядке
 * возрастания. В следующей строке записан номер сотрудника, который уйдет через t минут.
 *
 * В итоге план Кати следующий:
 *
 * Подняться на лифте на произвольный этаж. Считается, что лифт поднимается на любой этаж за 0 минут.
 * Передать всем коллегам договоры, перемещаясь между этажами по лестнице. Считается, что договоры на этаже передаются мгновенно.
 * В первые t минут передать договор тому коллеге, который планирует уйти.
 * Пройти минимальное количество лестничных пролетов.
 * Помогите Кате выполнить все пункты ее плана.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LiftAndKatya {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int t = Integer.parseInt(str[1]);
        String[] str2 = reader.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(str2[i]);
        }
        int index = Integer.parseInt(reader.readLine()) - 1;


        int result;
        if (array[index] - array[0] <= t | array[n-1] - array[index] <= t){
            result = array[n-1] - array[0];
        } else {
            int smallerDistance = array[index] - array[0];
            if (array[index] - array[0] > array[n-1] - array[index]){
                smallerDistance = array[n-1] - array[index];
            }
            result = array[n-1] - array[0] + smallerDistance;
        }

        System.out.println(result);
        reader.close();
    }
}