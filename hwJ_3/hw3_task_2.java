// Пусть дан произвольный список целых чисел, удалить из него четные числа
package hwJ_3;
import java.util.Arrays;
import java.util.ArrayList;

public class hw3_task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0;i<ints.size();i++)
        {
            if (ints.get(i) % 2 == 0) {
                ints.remove(i);
            }
        }System.out.println(ints);
    }
}