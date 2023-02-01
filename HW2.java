package Home_work_Java;
import java.io.*;
import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class HW2 {
    public static void main(String[] args) {
        
    }

    public static String ReadFile () {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) { 
            String fileName = "input.txt";
            String content = Files.lines(Paths.get(fileName)).reduce("", String::concat);
            //System.out.println(content);
            return content;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return "Exeprion";
    }


}
