public class hw1_task_2 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            boolean IsSimpleNumber = true;

            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    IsSimpleNumber = false;
                    break;
                }
            }
            if (IsSimpleNumber) {
                System.out.println(i);
            }
        }
    }
}
