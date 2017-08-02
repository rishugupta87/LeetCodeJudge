package companies.facebook;

/**
 * Created by rishugupta on 7/22/17.
 */
public class CountSubstringInString {

//    public static int countSubstring(String str, String subString) {
//        //edge cases
//
//        Pattern pattern = Pattern.compile(subString);
//        Matcher m = pattern.matcher(str);
//        int count = 0;
//
//        while (m.find()){
//            count +=1;
//        }
//        return count;
//    }

    public static int countSubstring2(String str, String subString) {
        if(str == null || str.length() == 0 || subString == null || subString.length() == 0) {
            return -1;
        }
        int index = str.indexOf(subString);

        if(index == -1) {
            return -1;
        }
        int count = 0;

        while (index != -1) {
            count++;
            str = str.substring(index + 1);
            index = str.indexOf(subString);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";

        System.out.println(countSubstring2(s, "aa"));
    }
}
