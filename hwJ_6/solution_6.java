package hwJ_6;

public class solution_6 {
    public static void main(String[] args) {
        Laptops item1 = new Laptops(1,"Acer", 2021, 17, true);
        Laptops item2 = new Laptops(1,"HP", 2020, 15, false);
        Laptops item3 = new Laptops(1,"Asus", 2021, 17, true);
        Laptops item4 = new Laptops(1,"Lenovo", 2020, 14, false);
        

        Laptops[] lapt = new Laptops[]{item1, item2, item3, item4};
        
        System.out.println(item1.HaveOrNotOs(lapt, true));
    }
}
