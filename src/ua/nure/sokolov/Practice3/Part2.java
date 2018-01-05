package ua.nure.sokolov.Practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private static GetInputFile classGetInputFile = new GetInputFile();
    private static String[] textOfInput;
    private static List<String> shortWordList = new ArrayList<>();
    private static List<String> longWordsList = new ArrayList<>();

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        System.out.println(part2.convert("part2.txt"));

//        System.out.println(part2.getMinWords());

    }


    public static String getMinWords(String input){
        String s = classGetInputFile.getInput(input);
//        textOfInput = s.split("[\\s.,?!]+");

        String regexp = "/^[a-z0-9-]+$/";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher  = pattern.matcher(s);

        String[] words = s.split("[\\s.,?!]+");
        String shortWOrds = words[0];

        for (int i = 0; i < words.length; i++){
            if (shortWOrds.length() > words[i].length()){
                shortWOrds = words[i];
            }
        }

        return shortWOrds;
    }

    public static String convert(String input){
        String s = classGetInputFile.getInput(input);
        textOfInput = s.split("[\\s-.,?!]+");

        String regexp = "/^[a-z0-9-]+$/";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher  = pattern.matcher(s);

        int maxLen = textOfInput[0].length();
        int min = textOfInput[4].length();

        for (int i = 0; i < textOfInput.length; i++){
            if (textOfInput[i].length() > maxLen){
                maxLen = textOfInput[i].length();
                longWordsList.add(textOfInput[i]);
            }else if(textOfInput[i].length() < min){
                shortWordList.add(textOfInput[i]);
            }
        }
        return "Min: " + String.valueOf(shortWordList) + System.lineSeparator() + "Max: " + String.valueOf(longWordsList);
    }

}
