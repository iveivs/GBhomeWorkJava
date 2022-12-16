package hwJ_6;

public class solution_6 {
    public static void main(String[] args) {
        Laptops item1 = new Laptops(1,"Acer", 2021, 17, true);
        Laptops item2 = new Laptops(1,"HP", 2020, 15, true);
        Laptops item3 = new Laptops(1,"Asus", 2021, 17, true);
        
        System.out.println(item1.toString(1));
        
        Laptops[] lapt = new Laptops[]{item1, item2, item3};

        System.out.println(item1.GetCatsByGender(lapt, true));
    
    }
}
