package Home_work_Java;

import java.io.*;
import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class HW2 {
    public static void main(String[] args) {

    }

    public static String ReadFile() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            String fileName = "input.txt";
            String content = Files.lines(Paths.get(fileName)).reduce("", String::concat);
            // System.out.println(content);
            return content;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "Exeprion";
    }

    public static String Exponential(String variabl) {
        double a = Double.valueOf(String.valueOf(
                variabl.substring(variabl.lastIndexOf("a ") + 1,
                        variabl.lastIndexOf("b"))));
        double b = Double.valueOf(String.valueOf(variabl.substring(variabl.lastIndexOf("b " + 1))));
        if (a == 0 && b == 0)
            return "Ошибка";
        else {
            double res = Math.pow(a, b);
            String result = String.valueOf(res);
            return result;
        }
    }

    public static void WriteFile(String res) {
        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            writer.write(res);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
