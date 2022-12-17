
// import java.io.FileWriter;
// import java.io.IOException;

import java.util.Arrays;

public class temp {

    public static void main(String[] args) {
        int [] mas = {11, 3, 14, 16, 7};

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;
                    
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }

}
// ________________________________


/*
 * 
 * 
 * Семинар 1

1. Вычислить сумму чисел от 1 до n и n! (произведение чисел от 1 до n)


import java.util.Scanner;

public class HW1_Sum1toN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n:");
        int n= scanner.nextInt();
        System.out.printf("Сумма от 1 до n равна %s\n", countNTriangle(n));
        System.out.printf("Произведение от 1 до n равно %s", factorial(n));
        scanner.close();
    }

    public static int countNTriangle(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;

        }
        return sum;
    }    
    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
            
        }
        return f;
    }    
}


2. Вывести все простые числа от 1 до 1000 

public class HW2_PrintPrime {

    public static void main(String[] args) {
        for (int index = 1; index < 1000; index++) {
            if (checkSimpleNumber(index) == true) {
                System.out.println(index);
            }
        }
    }

    public static Boolean checkSimpleNumber(int num) {   //функция определяет тип числа 

        for (int index = 2; index <= Math.sqrt(num); index++) {
            if ((num == 1) || (num % index == 0)) {
                return false;
            }
        }
        return true;
    }

}



3. Реализовать простой калькулятор + - / * 

import java.util.Scanner;

public class HW3_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //один раз создали и пользуемся!
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
        if (b != 0) return a/b;          
            else 
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




4. *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

Вариант 1 (простой)

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class HW4_Equation {
    public static void main(String[] args) {
        // Читаем выражение из файла input.txt
        String inputString = getDataFromFile("C:\\Users\\ovash\\Downloads\\JAVA\\Seminar1\\input.txt");
        System.out.println("Given the equation: " + inputString);
        // Вывод результата
        System.out.println(getSolution(inputString));
    }


    public static String getSolution(String str) {
        // Формируем список. Разделитель - пробел, "+" и "=" исключаем
        ArrayList<String> list = new ArrayList<>(List.of(str.split(" ")));
        list.remove("+");
        list.remove("=");


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Заменяем "?" в цикле от 0 до 9, сравниваем с результатом выражения
                int x = Integer.parseInt(list.get(0).replace("?", String.valueOf(i)));
                int y = Integer.parseInt(list.get(1).replace("?", String.valueOf(j)));
                if (x + y == Integer.parseInt(list.get(2))) {
                    // Решение найдено, формируем строку ответа
                    return String.format("Result: %d + %d = %d", x, y, Integer.parseInt(list.get(2)));
                }
            }
        }
        // Иначе решения нет
        return "No solution";
    }


    public static String getDataFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }
}

Вариант 2 (универсальный)


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public class HW4_Equation2 {
    public static void main(String[] args) {
        // Читаем выражение из файла input.txt
        String inputString = getDataFromFile("C:\\Users\\ovash\\Downloads\\JAVA\\Seminar1\\input.txt");
        System.out.println("Выражение: " + inputString);
        // Вывод результата
        getSolution(inputString);
    }


    public static void getSolution(String str) {
        // Подсчитываем количество знаков ?        
        int countSep = countChars(str, '?');
        System.out.println("Неизвестных: " + String.valueOf(countSep));
        // Вариантов подстановок цифр будет 10 в степени количества неизвестных
        for (int i = 0; i < Math.pow(10, countSep); i++){
            // Пробежимся в цикле по всем возможным вариантам 
            // Сформируем строку подстановки, которую будем использовать для подстановки цифр
            // Дополним строку нулями 
            // Например, если неизвестных 5: 00000, 00001, 00005
            String replacementString = String.format("%0"+String.valueOf(countSep) +"d", i);
            // Скопируем строку выражения 
            String newstr = str;
            // Подставим на места знаков ? соответсвующую цифру из строки подстановки
            for (int j = 0; j < countSep; j++){
                // Первый ? заменяется на первую цифру из строки подстановки, второй на вторую и т.д.    
                newstr = newstr.replaceFirst(String.valueOf("\\?"), String.valueOf(replacementString.charAt(j)));
            }     
            check(newstr);
        }       

    }

    // Проверка
    public static void check(String str) {
        // Формируем список. Разделитель - пробел, "+" и "=" исключаем
        ArrayList<String> list = new ArrayList<>(List.of(str.split(" ")));
        list.remove("+");
        list.remove("=");
        // Присвоим переменным
        int x = Integer.parseInt(list.get(0));
        int y = Integer.parseInt(list.get(1));
        int z = Integer.parseInt(list.get(2));
        // Проверим, получилось ли верное равенство
        if (x + y == z ){
            System.out.println(str); 
        }
    }

    // Вспомогательная функция для подсчета количества ? в строке
    public static int countChars(String Input, char SomeChar ) {
        int count = 0;
        for (int i = 0; i < Input.length(); i++) {
            if (Input.charAt(i) == SomeChar) {
                count++;
            }
        }
        return count;
    }
    // Чтение из файла
    public static String getDataFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }
}

Семинар 2.

ДЗ 1. Дана строка sql-запроса"select * from students where ".Сформируйте часть WHERE этого запроса,используя StringBuilder.Данные для фильтрации приведены ниже в виде json строки.Если значение null,то параметр не должен попадать в запрос.

Параметры для фильтрации:{"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}

public class MakeQuery {
    public static final String QUERY = "select * from students where ";
    public static final String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";

    public static void main(String[] args) {
        String paramsNew = PARAMS.replace('{', ' ').replace('}', ' ');
        String[] params = paramsNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(QUERY);
        for (int i = 0; i < params.length; i++) {
            String[] elements = params[i].replace('"', ' ').split(":");
            if (!"null".equals(elements[1].trim())) {
                stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                if (i < params.length - 2)
                    stringBuilder.append(" and ");
            }
        }
        System.out.println(stringBuilder);
    }
}

ДЗ 2.

Реализуйте алгоритм
сортировки пузырьком
числового массива, результат
после каждой
итерации запишите
в лог-файл
.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

public class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
            int[] mas = { 11, 3, 14, 16, 7 };
            bubbleSort(mas);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int[] bubbleSort(int[] mas) {
        boolean isSorted = false;
        int buffer;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    buffer = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buffer;
                }
            }
            // System.out.println(Arrays.toString(mas));
            logStep(Arrays.toString(mas));
        }
        return mas;
    }

    public static void logStep(String note) {
        try {
            fileWriter.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}

    ДЗ 3.

    Дана json

    строка (можно сохранить в файл и читать из файла)

[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.


3.	public class ParseJSON {    
    private static final String JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +            
    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +            
    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";    
    private static final String ELEMENT1 = "Студент ";    
    private static final String ELEMENT2 = " получил ";    
    private static final String ELEMENT3 = " по предмету ";    
    public static void main(String[] args) {        
        StringBuilder sb = new StringBuilder();        
        String newJSON = JSON.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\"", "").replace('[', ' ').replace(']', ' ');        
        //System.out.println(newJSON);        
        String[] parts = newJSON.split(",");        
        for (String part : parts){            
            String[] params = part.split(":");            
            if("фамилия".equals(params[0].trim())) 
            {                
                sb = new StringBuilder(ELEMENT1).append(params[1]);            
            }            else if("оценка".equals(params[0].trim())) sb.append(ELEMENT2).append(params[1]);            
            else if("предмет".equals(params[0].trim())) {                
                sb.append(ELEMENT3).append(params[1]);                
                System.out.println(sb);            }        }    }}


                ДЗ 4 *.
                К калькулятору из предыдущего дз добавить логирование.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Calculator {
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first number...");
            int a = scanner.nextInt();
            logStep("User entered the first operand = " + a);
            System.out.println("Enter the operator (+ - * /)...");
            char op = scanner.next().charAt(0);
            logStep("User entered the operation = " + op);
            System.out.println("Enter the second number...");
            int b = scanner.nextInt();
            logStep("User entered the first operand = " + b);
            int res;
            switch (op) {
                case '+':
                    res = add(a, b);
                    logStep("Result is " + res);
                    // System.out.println(a + " + " + b + " = " + add(a, b));
                    break;
                case '-':
                    res = minus(a, b);
                    logStep("Result is " + res);
                    // System.out.println(a + " - " + b + " = " + minus(a, b));
                    break;
                case '*':
                    res = mult(a, b);
                    logStep("Result is " + res);
                    // System.out.println(a + " * " + b + " = " + mult(a, b));
                    break;
                case '/':
                    res = divide(a, b);
                    logStep("Result is " + res);
                    // System.out.println(a + " / " + b + " = " + res);
                    break;
                default:
                    logStep("Wrong operation!");
                    // System.out.println("Wrong operation!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void logStep(String note) throws IOException {
        fileWriter.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
    }
}

Задание 1. Реализовать алгоритм сортировки слиянием

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 5, 1, 6, 2, 3, 4 };
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a,
            int[] l,
            int[] r,
            int left,
            int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }}

Задание 2. Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Arrays;

public class task0 {
    static public void main(String[] args)
    {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 4, 7, 8, 9));
        int i = 0;
        while(i<ints.size())
            {
                if (ints.get(i) % 2 == 0) {
                    ints.remove(i);
                }
                else i++;
            }
            System.out.println(ints);    
            
    }
}

Задание 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class task3 {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(3, 2, 4, 2, 5, 6, 1, 8, 7, 1));
        Collections.sort(ints);
        System.out.println(ints);
        System.out.println("Minimum is " + ints.get(0));
        System.out.println("Maximum is " + ints.get(ints.size() - 1));
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        System.out.println("Average is = " + sum / ints.size());
    }
}


Задание 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;

public class task1 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        System.out.println(ll);
        System.out.println(revert(ll));
    }

    private static LinkedList<Integer> revert(LinkedList<Integer> ll) {
        for (int i = 1; i < ll.size(); i++) {
            ll.addFirst(ll.remove(i));
        }
        return ll;
    }
}


 Задание 2. Реализуйте очередь с помощью LinkedList со следующими методами:
 - enqueue() - помещает элемент в конец очереди,
 - dequeue() - возвращает первый элемент из очереди и удаляет его,
 - first() - возвращает первый элемент из очереди, не удаляя.


import java.util.LinkedList;

public class MyQueue {
    private LinkedList elements = new LinkedList();

    public MyQueue() {
    }

    public MyQueue(LinkedList elements) {
        this.elements = elements;
    }

    public void enqueue(Object element) {
        elements.add(element);
    }

    public Object dequeue() {
        Object first = elements.getFirst();
        elements.removeFirst();
        return first;
    }

    public Object first() {
        return elements.getFirst();
    }

    public LinkedList getElements() {
        return elements;
    }

    public void setElements(LinkedList elements) {
        this.elements = elements;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(5);
        System.out.println(queue.getElements());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());
        System.out.println(queue.first());
    }
}



 Задание 3. * В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Calculator {
    private static File log;
    private static FileWriter fileWriter;
    private static Deque<Character> operationsStack = new ArrayDeque<>();
    private static Deque<String> resultsStack = new ArrayDeque<>();
    private static String lastResult;

    public static void main(String[] args) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
            boolean calc = true;
            Scanner scanner = new Scanner(System.in);
            while (calc) {
                System.out.println("Enter the first number...");
                int a = scanner.nextInt();
                logStep("User entered the first operand = " + a);
                 System.out.println("Enter the operator (+ - * /) or < to cancel the last operation or ! to exit...");
                char op = scanner.next().trim().charAt(0);
                logStep("User entered the operation = " + op);
                if ('!' == op)
                    return;
                int b = 0;
                if ('<' != op) {
                    System.out.println("Enter the second number...");
                    b = scanner.nextInt();
                    logStep("User entered the first operand = " + b);
                }
                int res;
                switch (op) {
                    case '+':
                        res = add(a, b);
                        lastResult = "Result is " + res;
                        resultsStack.push(lastResult);
                        operationsStack.push('+');
                        logStep(lastResult);
                        System.out.println(a + " + " + b + " = " + add(a, b));
                        break;
                    case '-':
                        res = minus(a, b);
                        lastResult = "Result is " + res;
                        resultsStack.push(lastResult);
                        operationsStack.push('-');
                        logStep(lastResult);
                        System.out.println(a + " - " + b + " = " + minus(a, b));
                        break;
                    case '*':
                        res = mult(a, b);
                        lastResult = "Result is " + res;
                        resultsStack.push(lastResult);
                        operationsStack.push('*');
                        logStep(lastResult);
                        System.out.println(a + " * " + b + " = " + mult(a, b));
                        break;
                    case '/':
                        res = divide(a, b);
                        lastResult = "Result is " + res;
                        resultsStack.push(lastResult);
                        operationsStack.push('/');
                        logStep(lastResult);
                        System.out.println(a + " / " + b + " = " + res);
                        break;
                    case '<':
                        operationsStack.removeFirst();
                        resultsStack.removeFirst();
                        System.out.println("Previous " + resultsStack.peekFirst());
                        break;
                    default:
                        logStep("Wrong operation!");
                        System.out.println("Wrong operation!");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public static void logStep(String note) throws IOException {
        fileWriter.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
    }
}

 */
