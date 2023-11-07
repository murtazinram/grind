package org.example.excelSheetColumnTitle;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 168. Excel Sheet Column Title
 * Easy
 * 5.3K
 * 746
 * Companies
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 * <p>
 * Input: columnNumber = 28
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: columnNumber = 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {

        char a = 'A';//65 -> 1
        char b = 'B';//
        char z = 'Z';//90 -> 26
        int numericValue = Character.getNumericValue(b);
        char v = (char) (1 + 64);
        //System.out.println(String.valueOf(v));


        String s = convertToTitle(701);
        System.out.println(s);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        //28 "AB"
        while (columnNumber != 0){
            columnNumber--;
            int i = columnNumber % 26;
            char v = (char) (i + 'A');
            System.out.println(String.valueOf(v));
            builder.append(v);

            System.out.println(i);
            columnNumber /= 26;
        }
        return builder.reverse().toString();
    }
}
