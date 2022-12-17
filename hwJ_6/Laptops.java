package hwJ_6;
import java.util.Scanner;

public class Laptops {
    int id;
    String name;
    int age, dispSize;
    boolean oS;

    public Laptops(int id, String name, int age, int dispSize, boolean oS) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dispSize = dispSize;
        this.oS = oS;
    }

    public String toString(int number) {
        String temp = this.oS ? "Have Os" : "Doesn't have Os";
        return "Laptop's number: " + number + "\n" +
                "Name: " + name + "\n" +
                "OperationSystem: " + temp + "\n" +
                "Display Size: " + dispSize + "\n" +
                "Age: " + age + "\n";
        }

    
    public StringBuilder HaveOrNotOs(Laptops[] lapt, boolean oS) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите '1' если нужна модель с ОС, если без ОС то введите '2'...");
        int num = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        if (num == 1){
            oS = true;
            for (Laptops c: lapt) {
                if (c.oS==oS){
                    result.append(c.name);
                    result.append(" ");
                }
            }
        }
        if (num == 2){
            oS = false;
            for (Laptops c: lapt) {
                if (c.oS==oS){
                    result.append(c.name);
                    result.append(" ");
                }
            }
        }
        scanner.close(); 
        return result;          
    }
            
        
}


    


















    // public StringBuilder GetLaptopOs(Laptops[] lapt, boolean oS) {
    //     StringBuilder result = new StringBuilder();
    //     for (Laptops c: lapt) {
    //         if (c.oS==oS){
    //             result.append(c.name);
    //             result.append(" ");
    //         }
    //     }
    //     return result;
    // }

