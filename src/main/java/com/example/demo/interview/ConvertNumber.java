package com.example.demo.interview;

import com.google.common.base.Strings;
import io.netty.util.internal.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入一串数字，然后转换成英文方式的输出。
 * 如：
 *  输入为：23，432 输出为：twenty three thousand four hundred and thirty two
 *
 *
 *  英文中的数字：
 *      one, two, three, four, five, six, seven, eight, nine, ten
 *      eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty
 *
 *      100（百）:　hundred
 *      1000（千）:　thousand
 *      1000000(百万):　million
 *      1000000000（十亿）: billion
 *
 */
public class ConvertNumber {

//    private final static String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    private final static Map<Integer, String> NUMBERS = new HashMap<Integer, String>()
    {
        {
            put(0, "zero");
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirteen");
            put(14, "fourteen");
            put(15, "fifteen");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");

            put(20, "twenty");
            put(30, "thirty");
            put(40, "forty");
            put(50, "fifty");
            put(60, "sixty");
            put(70, "seventy");
            put(80, "eighty");
            put(90, "ninety");

            put(100, "hundred");
            put(1000, "thousand");
            put(1000000, "million");
            put(1000000000, "billion");

        }
    };

    public static void main(String[] args) {

        System.out.println("请输入数字金额，按回车键结束：  ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String numberString = getNumberString(str);
            String engString = changeToEng(numberString);
            System.out.println("您输入的金额为：" + engString);
            String result = buildMount(engString);
            System.out.println(result);
        }



    }

    /**
     * 把英文格式的数字转换成带单位的字母形式
     * @param str
     * @return
     */
    public static String buildMount(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return "";
        }
        String[] array = str.split(",");

        StringBuilder result = new StringBuilder("");

        for (int i = 0;i< array.length; i++) {
            String value = array[i];
            String engValue = convertNumberToEng(value);
            result.append(engValue).append(" ");

            switch (array.length) {
                case 4:
                    if (i ==0) {
                        result.append(NUMBERS.get(1000000000)).append(", ");
                    }
                    if (i ==1) {
                        result.append(NUMBERS.get(1000000)).append(", ");
                    }
                    if (i ==2) {
                        result.append(NUMBERS.get(1000)).append(", ");
                    }
                    break;
                case 3:
                    if (i ==0) {
                        result.append(NUMBERS.get(1000000)).append(", ");
                    }
                    if (i ==1) {
                        result.append(NUMBERS.get(1000)).append(", ");
                    }
                    break;
                case 2:
                    if (i ==0) {
                        result.append(NUMBERS.get(1000)).append(", ");
                    }
                    break;
                case 1:
                    break;
                default:
                    break;
            }


        }
        return result.toString();
    }

    /**
     * 把数字转换成带逗号的表达式
     * 12345678 ----> 12,345,678
     * @param str
     * @return
     */
    public static String changeToEng(String str){
        if (str.length() <= 3) {
            return str;
        }

        StringBuffer sb = new StringBuffer("");
        int end = str.length()/3;

        for (int i = end; i >= 0; i--) {
            String subString = "";
            int endIndex = str.length() - (i)*3;
            int startIndex = 0;
            if (endIndex > 3) {
             startIndex = endIndex - 3;
            }
            String substring = str.substring(startIndex, endIndex);
            if (!Strings.isNullOrEmpty(substring)) {
                subString = str.substring(startIndex, endIndex) + ",";
                sb.append(subString);
            }
        }

        return sb.substring(0, sb.length()-1).toString();
    }

    /**
     * 把3位数字转换成英文字母形式
     *  123 ===> one hundred and twenty three
     *  205 ===> two hundreds and o five
     *  12 ===> twelve
     * @param str
     * @return
     */
    public static String convertNumberToEng(String str) {
        StringBuilder result = new StringBuilder("");
        char[] chars = str.toCharArray();
        if (str.length() == 1) {
            String hundredValue = String.valueOf(chars[0]);
            int index = Integer.valueOf(hundredValue.toString());
            String engValue = NUMBERS.get(index);
            return engValue;
        }

        if (str.length() == 2) {
            String decadeValue = String.valueOf(chars[0]);
            String unitValue = String.valueOf(chars[1]);
            int index = Integer.valueOf(decadeValue.toString()) * 10 + Integer.valueOf(unitValue.toString());
            String engValue = NUMBERS.get(index);
            if (Strings.isNullOrEmpty(engValue)) {
                result.append(NUMBERS.get(Integer.valueOf(decadeValue.toString()) * 10)).append(" ").append(NUMBERS.get(Integer.valueOf(unitValue.toString())));
            } else {
                result.append(NUMBERS.get(index)).append(" ");
            }
        } else {
            String hundredValue = String.valueOf(chars[0]);
            int index = Integer.valueOf(hundredValue.toString());
            String engValue = NUMBERS.get(index);
            if (index > 1) {
                result.append(engValue).append(" ").append(NUMBERS.get(100)).append("s ");
            } else {
                result.append(engValue).append(" ").append(NUMBERS.get(100)).append(" ");
            }

            if (!checkZero(str)) {
                result.append(" and ");
                String decadeValue = String.valueOf(chars[1]);
                String unitValue = String.valueOf(chars[2]);
                index = Integer.valueOf(decadeValue.toString()) * 10 + Integer.valueOf(unitValue.toString());
                engValue = NUMBERS.get(index);
                if (Strings.isNullOrEmpty(engValue)) {
                    result.append(NUMBERS.get(Integer.valueOf(decadeValue.toString()) * 10)).append(" ").append(NUMBERS.get(Integer.valueOf(unitValue.toString())));
                } else {
                    result.append(engValue).append(" ");
                }
            }

        }
        return result.toString();
    }

    private static Boolean checkZero(String str) {
        if (str.endsWith("00")) {
            return true;
        }
        return false;
    }

    private static String getNumberString(String str) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("").trim();
    }

}
