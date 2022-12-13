package hwJ_5;
import java.util.*;

public class hwJ_task_1 {
    public static void main(String[] args) {
    Map<Integer, String> db = new HashMap<>();
        db.put(123456, "Чичиков");
        db.put(193827, "Манилов"); 
        db.put(123321, "Коробочка"); 
        db.put(654321, "Чичиков");
        db.put(1010011010, "Плюшкин");
        db.put(999999, "Собакевич"); 
        db.put(666666, "Ноздрёв"); 

        Scanner iScaner = new Scanner(System.in);
        System.out.printf("У кого будем 'души' покупать ?: ");
        String str = iScaner.nextLine();
        iScaner.close();

        for (Integer mastersNum: db.keySet()) {
            if (Objects.equals(db.get(mastersNum), str)) {
                System.out.printf("Телефонъ: %d фамилия помещика: %s\n", mastersNum, db.get(mastersNum));
            }
        }
    }
}
