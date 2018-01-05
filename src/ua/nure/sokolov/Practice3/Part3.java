package ua.nure.sokolov.Practice3;

public class Part3 {
    private GetInputFile classGetInputFile = new GetInputFile();
    private String[] textOfInput;
    private StringBuilder sbResult = new StringBuilder();

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        System.out.println(part3.convert("part3.txt"));
    }

    public String convert(String input){
        String s = classGetInputFile.getInput(input);
        textOfInput = s.split("[\\s.,?!]+");

        for (int j = 0; j < textOfInput.length; j++){
            if (textOfInput[j].equals(null)){
                return " ";
            }else{
                sbResult.append(textOfInput[j].substring(0,1).toUpperCase() + textOfInput[j].substring(1) + " ");
            }
        }

        return String.valueOf(sbResult);
    }
}
