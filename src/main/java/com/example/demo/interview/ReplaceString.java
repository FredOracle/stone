package com.example.demo.interview;

import java.util.Scanner;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println(ReplaceString.replaceSpace(new StringBuffer(str)));
        }
    }

    private static String replaceSpace(StringBuffer str){
        return str.toString().replace(" ", "%20");
    }
}
