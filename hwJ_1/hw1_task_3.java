import java.util.Scanner;

public class hw1_task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number...");
        int a = scanner.nextInt();
        System.out.println("Enter the operator (+ - * /)...");
        char op = scanner.next().charAt(0);
        System.out.println("Enter the second number...");
        int b = scanner.nextInt();
        switch (op) {
            case '+':
                System.out.println(a + " + " + b + " = " + add(a, b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + minus(a, b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + mult(a, b));
                break;
            case '/':
                System.out.println(a + " / " + b + " = " + divide(a, b));
                break;
            default:
                System.out.println("Wrong operation!");
        }
        scanner.close();
    }
    private static int divide(int a, int b) {
        if (b != 0)
            return a / b;
        return -1;
    }
    private static int mult(int a, int b) {
        return a * b;
    }
    private static int minus(int a, int b) {
        return a - b;
    }
    private static int add(int a, int b) {
        return a + b;
    }
}

