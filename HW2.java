package Home_work_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.Math;
import java.nio.charset.Charset;


public class HW2 {       
    public static HashMap<String, Integer> tr = new HashMap<>();


    public static void main(String[] args) {
        String[] textFromFile = new String[0];


        textFromFile = DataFromFile();
        for(String i: textFromFile){
            // System.out.println(i);
            SelectData(i);
        }
        int a = tr.get("a");
        int b = tr.get("b");
        String forZap = "";
        if(a != 0){
            double resStep = Stepen(a, b);
            forZap = String.valueOf(resStep);
        }
        else {
            forZap = "не определено";
        }
       
        DataInFile(forZap);

    }
    static void SelectData(String inText){
        String [] resTxt = new String[]{};
        resTxt = inText.split(" ");
        tr.put(resTxt[0].toString(), Integer.parseInt(resTxt[1]));
    }

    static String[] DataFromFile(){
        String[] resData = new String[0];
        String lineStr = "";
        int lenMass = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(".//Home_work_Java//input.txt", Charset.forName("UTF-8")))) {            
            while((lineStr = br.readLine()) != null){
                resData = Arrays.copyOf(resData, lenMass + 1);
                resData[lenMass] = lineStr;
                lenMass++;
            }            
        }
        catch(IOException ex){
            System.out.println("Файл не найден!");
        }
        return resData;
    }

    static void DataInFile(String txtZap){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(".//Home_work_Java//output.txt", Charset.forName("UTF-8")))) {
		        bw.write(txtZap);
		    }
		    catch(IOException ex){		
		        System.out.println(ex.getMessage());
		    }
    }

    static double Stepen(int inA, int inB){
        return Math.pow((double) inA, (double) inB);
    }

}
