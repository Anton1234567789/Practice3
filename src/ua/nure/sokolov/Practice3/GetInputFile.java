package ua.nure.sokolov.Practice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetInputFile {

    public String getInput(String fileName){
        StringBuilder sb = new StringBuilder();
        try{
            Scanner scanner=new Scanner(new File(fileName),"UTF-8");
            while(scanner.hasNextLine()){
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
