package ua.nure.sokolov.Practice3;

public class Part5 {


    private static String [] romanSimbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static int [] arabicSimbols = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    static int last = 2000;

    public static void main(String [] args)
    {
            System.out.println(decimal2Roman(2004));
        System.out.println(roman2Decimal(decimal2Roman(2004)));
    }

    public static String convert2Roman(int aNumber)
    {
        String numeric="";
        int bitDepth;
        int index=0;
        while (index< arabicSimbols.length)
        {
            bitDepth = (int)aNumber/ arabicSimbols[index];
            for (int i = 0; i < bitDepth; i++)
            {
                numeric += romanSimbols[index];
            }
            aNumber -= bitDepth* arabicSimbols[index];
            index++;
        }
        return numeric;
    }

    public static String decimal2Roman(int number) {
        String[] romanSymbol = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] arabicSymbol = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder s = new StringBuilder();

        for (int i = romanSymbol.length - 1; i >= 0; i--) {
            while (number >= arabicSymbol[i]) {
                s.append(romanSymbol[i]);
                number -= arabicSymbol[i];
            }
        }
        return s.toString();
    }

    public static int roman2Decimal(String romanNumeral) throws NumberFormatException
    {
        int integerValue = 0;


        for (int i = 0; i < romanNumeral.length(); i++)
        {
            char ch = romanNumeral.charAt( i );

            int number = letterToNumber( ch );

            if ( number == -1)
            {
                throw new NumberFormatException("Invalid format");
            }


            if (last<number) {
                number = number - last - 1;
            }
            integerValue += number;
            last = number;
        }

        return integerValue;
    }

    private static int letterToNumber(char letter)
    {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }


}
