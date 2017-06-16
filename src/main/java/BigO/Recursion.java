package BigO;

public class Recursion {
    int pairSequence(int n) {
        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    private int pairSum(final int num1, final int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        Recursion rec = new Recursion();
        System.out.println(rec.pairSequence(4));
    }
}
