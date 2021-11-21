package q1;

public class StringToInteger {

    public static int convert(String s) {
        boolean isPositive;
        int numberOfString = 0;

        if (s == null)
            throw new NumberFormatException("Your input must be not null!");

        if (s.charAt(0) == '-') {
            isPositive = false;
            s = s.substring(1);
        } else {
            isPositive = true;
        }

        char[] numbers = s.toCharArray();

        for (int number : numbers) {
            if (number < '0' || number > '9')
                throw new NumberFormatException("Number should be numerical.");
            numberOfString = (numberOfString * 10) + (number - '0');
        }

        if (numberOfString > 32767 || numberOfString < -32767) {
            throw new NumberFormatException("Number should be between -32767 and 32767");
        }
        return isPositive ? numberOfString : -numberOfString;
    }
}
