package hwJ_5;
import java.util.*;

public class hwJ_5_task_2 {
    public static void main(String[] args) {
        String st = "Иван Иванов Светлана Петрова Кристина Белова Анна Мусина Анна Крутова Иван Юрин Петр Лыков Павел Чернов Петр Чернышов Мария Федорова Марина Светлова Мария Савина Мария Рыкова Марина Лугова Анна Владимирова Иван Мечников Петр Петин Иван Ежов";

        String[] words = st.split(" ");

        HashMap<String,Integer> keyValue = new HashMap<String,Integer>();

        for (int i=0; i<= words.length-1; i++) {

                if (keyValue.containsKey(words[i])) {

                        int counter = keyValue.get(words[i]);

                        keyValue.put(words[i], counter+1);

                }

                else {

                        keyValue.put(words[i], 1);

                }

        }

        System.out.println(keyValue);
    }
}
