import java.awt.*;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
//      ноемр 1
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));
//      ноемр 2
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19}));
//      ноемр 3
        System.out.println(isAvgWhole(new double[]{1, 3}));
        System.out.println(isAvgWhole(new double[]{1, 2, 3, 4}));
        System.out.println(isAvgWhole(new double[]{1, 5, 6}));
        System.out.println(isAvgWhole(new double[]{1, 1, 1}));
        System.out.println(isAvgWhole(new double[]{9, 2, 2, 5}));
//      ноемр 4
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));
//      ноемр 5
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
//      ноемр 6
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(12));
//      ноемр 7
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
//      ноемр 8
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
//      ноемр 9
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
//      ноемр 10
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
    }

    public static String repeat(String s, int n) {
        String sim = "";
        // проходим по всем символам и дублируем их n раз
        for (char i : s.toCharArray()) {
            sim += Character.toString(i).repeat(n);
        }
        return sim;
    }

    public static int differenceMaxMin(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (max < mas[i]) {
                max = mas[i];
            }
            if (min > mas[i]) {
                min = mas[i];
            }
        }
        return (max - min);
    }

    public static boolean isAvgWhole(double[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum % array.length == 0;
    }

    public static int[] cumulativeSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        return array;
    }

    public static int getDecimalPlaces(String num) {
        int count = 0;
        if (num.contains(".")) {
            String[] arr = num.split(Pattern.quote("."));//создаем массив, с помошью метода split делим строку на 2 элемента массива (0 - до точки, 1 - после точки)
            count = arr[1].length();
        }
        return count;
    }


    public static int fibonacci(int n) {
        int a = 1;
        int b = 1;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static boolean isValid(String s) {
        if (s.length() != 5) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!(Character.isDigit(letter))) {// проверка что только числа
                return false;
            }
        }
        return true;
    }

    public static boolean isStrangePair(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        } else if (s1.length() == 0 || s2.length() == 0) {
            return false;

        }
        return ((s1.charAt(0) == s2.charAt(s2.length() - 1)) && (s1.charAt(s1.length() - 1) == s2.charAt(0)));
    }


    public static boolean isPrefix(String word, String prefix) {
        char[] word1 = word.toCharArray();
        char[] word2 = prefix.toCharArray();
        for (int i = 0; i < prefix.length() - 1; i++) {
            if (word2[i] == word1[i])
                return true;
        }
        return false;
    }

    public static boolean isSuffix(String str1, String str2) {
        char[] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();
        for (int i = string1.length - string2.length + 1; i < string1.length; i++) { // вычитаем из кол - ва элементов 1 массива кол - во элементов 2 и прибавляем 1
            for (int j = 1; j < string2.length; j++) { // стартуем от 1 элемента и двигаемся до конца массива
                if ((string1[i] == string2[j]) && (string2[string2.length - 1] != '-')) // если элемент 1 массива = элементу 2 массива и последний элемент 2 массива не равен "-", то true
                    return true;
            }
        }
        return false;
    }

    public static int boxSeq(int number) {
        if (number % 2 == 0) {
            return number;
        } else {
            return number + 2;
        }
    }
}