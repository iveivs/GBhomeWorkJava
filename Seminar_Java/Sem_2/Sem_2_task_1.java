// Задание 1.
// Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.

// Ответ: 
// с1 = а
// с2 = б

// абабабабаб (всего N символов)

package Seminar_Java.Sem_2;
import java.util.Scanner;

public class Sem_2_task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = scanner.nextInt();

        System.out.println("Первый символ - c1:");
        // String c1 = scanner.nextLine();
        char c1 = scanner.next().charAt(0);

        System.out.println("Второй символ - c2:");
        // String c2 = scanner.nextLine();
        char c2 = scanner.next().charAt(0);

        scanner.close();

        StringBuilder sres = new StringBuilder();
        for (int i = 1; i < n ; i++) {
            if (i % 2 == 0) {
                sres.append(c1);
            } else {
                sres.append(c2);
            }
        }
        System.out.println(sres);

        // sres.append((c1+c2).repeat(Math.max(0, n / 2)));   укороченный вариант

    }
}

