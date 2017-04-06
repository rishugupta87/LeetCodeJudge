package Math.Q_17_AddDigits;

/**
 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigitsWithoutRecursion {

    /**
     * for any number < 9 return num
     *
     * Observe the pattern
     * 10, 11, 12, ......18  = will have sum from 1, 2, 3....9
     * 19, 20, 21,.......27  = will have sum from 1, 2, 3....9
     * 28, 29, 30,.......36  = will have sum from 1, 2, 3....9
     *
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if(num <= 9) {
            return num;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
