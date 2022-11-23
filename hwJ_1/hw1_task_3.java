import java.util.Scanner;

public class hw1_task_3 {
    public static void main(String[] args) {

        Scanner xScanner = new Scanner(System.in);

        System.out.printf("input x: ");

        int x = xScanner.nextInt();


        Scanner yScanner = new Scanner(System.in);

        System.out.printf("input y: ");

        int y = yScanner.nextInt();


        Scanner signScanner = new Scanner(System.in);

        System.out.printf("input operation: ");

        String sign = signScanner.nextLine();

        

        if (sign == "+") {
            int res = 0;
            res = x + y;
            System.out.println(res);
        }
        else if (sign == "-") {
            int res = 0;
            res = x - y;
            System.out.println(res);
        }
        else if (sign == "*") {
            int res = 0;
            res = x * y;
            System.out.println(res);
        }
        else if (y != 0 && sign == "/") {
            int res = 0;
            res = x / y;
            System.out.println(res);
        }
    }
}
