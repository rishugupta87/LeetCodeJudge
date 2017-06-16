package ArraysAndString.Q_21_LengthOfLastWord;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string. If the last word does not exist, return 0.
 */
public class LastWordLength {

    /**
     * Very simple question. We just need a flag to mark the start of letters from the end.
     * If a letter starts and the next character is not a letter, return the length.
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s==null || s.length() == 0)
            return 0;

        int result = 0;
        int len = s.length();

        boolean flag = false;
        for(int i=len-1; i>=0; i--){
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')){
                flag = true;
                result++;
            }else{
                if(flag)
                    return result;
            }
        }

        return result;
    }
}
