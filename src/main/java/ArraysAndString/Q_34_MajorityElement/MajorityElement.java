package ArraysAndString.Q_34_MajorityElement;

/**
 * http://www.programcreek.com/2014/02/leetcode-majority-element-java/
 */
public class MajorityElement {

    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
