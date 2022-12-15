package Lesson_06;

import java.util.Arrays;
import java.util.HashSet;

public class ex_001 {
    public static void main(String[] args) {
        Worker w1 = new Worker();
        w1.id = 1000;
        w1.salary = 100;
        w1.firstName = "Имя_1";
        w1.lastName = "Фамилия_1";

        Worker w4 = new Worker();
        w4.id = 1000;
        w4.salary = 100;
        w4.firstName = "Имя_1";
        w4.lastName = "Фамилия_1";

        Worker w2 = new Worker();
        w2.id = 2000;
        w2.salary = 200;
        w2.firstName = "Имя_2";
        w2.lastName = "Фамилия_2";

        Worker w3 = new Worker();
        w3.id = 3000;
        w3.salary = 300;
        w3.firstName = "Имя_3";
        w3.lastName = "Фамилия_3";

        System.out.println(w1.toString());
        System.out.println(w2);
        System.out.println(w3);
        System.out.println(w4);
        

        System.out.println(w1 == w4);
        System.out.println(w1.equals(w4));
        var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
        System.out.println(workers.contains(w4));
        
    }
}
