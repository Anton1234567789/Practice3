package ua.nure.sokolov.Practice3;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static GetInputFile classGetInputFile = new GetInputFile();
    public static void main(String[] args) {
        Part1 part1 = new Part1();

        System.out.println(part1.convert1("part1.txt"));
//        System.out.println(part1.convert2());
//        System.out.println(part1.convert3());
//        System.out.println(part1.convert4());

    }

    public static String convert1(String input){
        StringBuilder result = new StringBuilder("");
        String INPUT_FILE = classGetInputFile.getInput(input);
        String regexp = "(?m)^([^;]+);(.+?) (.+?);([^;]+)$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher  = pattern.matcher(INPUT_FILE);

        while (matcher.find()){
            result.append(matcher.group(1));
            result.append(" ==> ");
            result.append(matcher.group(4)+ System.lineSeparator());
        }

      return String.valueOf(result);
    }

    public static String convert2(String input){
        StringBuilder result = new StringBuilder("");
        String INPUT_FILE = classGetInputFile.getInput(input);
        String regexp = "(?m)^([^;]+);(.+?) (.+?);([^;]+)$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher  = pattern.matcher(INPUT_FILE);

        while (matcher.find()){
            result.append(matcher.group(3));
            result.append(" "+matcher.group(2));
            result.append(" (" + "email: ");
            result.append(matcher.group(4));
            result.append(")"+ System.lineSeparator());
        }

        return String.valueOf(result);
    }


//    mail.ru ==> ivanov, bush
//    google.com ==> petrov, obama
    public static String convert3(String input){
        StringBuilder resultMail = new StringBuilder("");
        StringBuilder resultGoogle = new StringBuilder("");
        List<String> listForEmail = new ArrayList<>();
        List<String> listForLastname= new ArrayList<>();
        String INPUT_FILE = classGetInputFile.getInput(input);
        String regexp = "(?m)^([^;]+);([^;]+);([^;]+)(\\@)((\\w+\\.)(\\w+))$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher  = pattern.matcher(INPUT_FILE);
        int countForOutputEmailAndLastName = 0;
        int countForMail = 0;
        int countForGoogle = 0;
            while (matcher.find()){
                listForEmail.add(matcher.group(5));
                listForLastname.add(matcher.group(1));
                if (listForEmail.get(countForOutputEmailAndLastName).equals("mail.ru")){
                    if (countForMail == 0) {
                        resultMail.append(listForEmail.get(countForOutputEmailAndLastName) + " ==> ");
                        countForMail++;
                    }
                    if (listForEmail.get(0) != null) {
                        if (countForMail > 0){
                            Iterator iterator = listForLastname.iterator();
                            resultMail.append(listForLastname.get(countForOutputEmailAndLastName) + " ");

                        }
                    }
                }else {
                    if (listForEmail.get(countForOutputEmailAndLastName).equals("google.com")){
                        if (countForGoogle == 0){
                            resultGoogle.append(listForEmail.get(countForOutputEmailAndLastName) + " ==> ");
                            countForGoogle++;
                        }
                        resultGoogle.append(listForLastname.get(countForOutputEmailAndLastName) + " ");
                    }
                }
                countForOutputEmailAndLastName++;
            }

        resultMail.append(System.lineSeparator() + resultGoogle);

        return String.valueOf(resultMail);
    }

    public static String convert4(String input){
        StringBuilder result = new StringBuilder("");
        String INPUT_FILE = classGetInputFile.getInput(input);
        String regexp = "(?m)^([^;]+);([^;]+);([^;]+)$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher  = pattern.matcher(INPUT_FILE);
        int i = 0;

        while (matcher.find()){
            if (i==0){
                result.append(matcher.group(0) + ";Password" + System.lineSeparator());
                i++;
            }else {
              result.append(matcher.group()+ ";" + (int)(Math.random()*9000+1000)+ System.lineSeparator());
            }
        }

        return String.valueOf(result);

    }

}
