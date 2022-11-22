import java.util.Scanner;

public class hw1_task_1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        System.out.printf("int n: ");

        int x = iScanner.nextInt();

        int mult = 1;

        for (int i = 1; i <= x; i++) {
            mult = mult * i;
        }

        System.out.println(mult);

        iScanner.close();


    }
}