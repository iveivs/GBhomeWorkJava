package Seminar_Java.Sem_2;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Sem_2_task_5 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        File dir = new File(".");

        File[] filesList = dir.listFiles();
        List<String> l = new ArrayList<>();
        for (File file : filesList) {
            if (file.isFile()) {
                System.out.printf(" %s\n", file.getName());
            } else {
                System.out.println(file.getName());
            }

        try (FileWriter fw = new FileWriter("file.txt", false)) {
            for (File f : filesList) {
                fw.write(f.toString());
                fw.write("\n");
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }
        }


        
    }
}
