package hwJ_6;

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
        String temp = this.oS ? "Male" : "Female";
        return "Cat's number: " + number + "\n" +
                "Name: " + name + "\n" +
                "OperationSystem: " + temp + "\n" +
                "Display Size: " + dispSize + "\n" +
                "Age: " + age + "\n";
        }

    public StringBuilder GetCatsByGender(Laptops[] cats, boolean gender) {
        StringBuilder result = new StringBuilder();
        for (Laptops c: cats) {
            if (c.oS==oS){
                result.append(c.name);
                result.append(" ");
            }
        }
        return result;
    }
}


    

