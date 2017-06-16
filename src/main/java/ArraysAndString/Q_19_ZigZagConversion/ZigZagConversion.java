package ArraysAndString.Q_19_ZigZagConversion;

import java.util.Arrays;

/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern
 in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

    /**
     * Here you have implemented using a 2d array, but this is not a good approach.
     * since you dont know the number of columns and this takes O(n^2) space.
     * Try using a stringBuilder instead. See the other solution.
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if(s.length() == 0) {
            return "";
        }

        if(numRows <= 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        char [][] table = new char[numRows][7];

        int k = 0, i = 0, j = 0;
        table[0][0] = charArray[0];

        while(k < s.length() - 1) {
            while(i < numRows - 1 && k < s.length()-1) {
                table[++i][j] = charArray[++k];
            }

            while (i > 0 && k < s.length()-1) {
                table[--i][++j] = charArray[++k];
            }
        }

        return getStringFromTableArray(table, numRows);
    }

    private static String getStringFromTableArray(final char[][] table, int numRows) {
        System.out.println(Arrays.deepToString(table)); // this is how it looks in the table
        StringBuilder sb = new StringBuilder();
        for(int p = 0 ; p < numRows; p ++) {
            for(int q = 0 ; q < 7; q++) {
                if(table[p][q] != (char)0) {
                    sb.append(table[p][q]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
