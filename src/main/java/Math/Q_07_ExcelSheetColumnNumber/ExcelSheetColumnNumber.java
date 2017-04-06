package Math.Q_07_ExcelSheetColumnNumber;

/**
 Given a column title as appear in an Excel sheet, return its corresponding column number. For example:
 A  -> 1
 B  -> 2
 C  -> 3
 ...
 Z  -> 26
 AA -> 27
 AB -> 28
 ...
 AAA -> 703
 */
public class ExcelSheetColumnNumber {
    /**
       http://www.asciitable.com/
       ascii value of A = 65
       ascii value of Z = 90

       Solution:
       To get column number from A--to Z is simple

       ex to get column number for "E" = asciiVal Of E - ascii value of A + 1
       69 - 65 + 1 = 5

       for AA = (column no for A) * 26^1 + (column no for A) = 1 * 26 + 1 = 27
       for BA = (column no for B) * 26^1 + (column no for A) = 2 * 26 + 1 = 53
       for BF = (column no for B) * 26^1 + (column no for F) = 2 * 26 + 6 = 58

       for ZZ = (column no for Z) * 26^1 + (column no for Z) = 26 * 26 + 26 = 702
       for AAA = (column no for A) * 26^2 + (column no for A) * 26 ^ 1 + (column no for A) * 26 ^ 0 = 1*26^2 + 1*26 + 1 = 676 + 26 + 1 = 703

     * @param title
     * @return
     */
    public static int getExcelSheetColumnNumber(final String title) {
        if(title == null || title.length() == 0) {
            return 0;
        }
        if(title.length() == 1) { // if a single character string.
            int asciiVal = title.charAt(0);
            return asciiVal - 'A' + 1;
        }
        char[] chars = title.toCharArray();
        int i = 0;
        int result = 0;
        int size = chars.length;

        while(i < size) {
            int exponent = size - i - 1;
            int asciiVal = chars[i];
            result +=  Math.pow(26, exponent) * (asciiVal - 'A' + 1) ;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getExcelSheetColumnNumber("AAA"));

    }
}
