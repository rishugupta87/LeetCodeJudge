package Math.Q_11_CountPrimes;

/**
 * Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrimes {

    /**
     * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     *
     find all the prime numbers less than or equal to 30, proceed as follows.

     First generate a list of integers from 2 to 30:

     2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30

     The first number in the list is 2; cross out every 2nd number in the list after 2 by counting up from 2 in increments of
     2 (these will be all the multiples of 2 in the list):

     The next number in the list after 2 is 3; cross out every 3rd number in the list after 3 by counting up from 3
     in increments of 3 (these will be all the multiples of 3 in the list):

     The next number not yet crossed out in the list after 3 is 5; cross out every 5th number in the list after 5
     by counting up from 5 in increments of 5 (i.e. all the multiples of 5):

     The next number not yet crossed out in the list after 5 is 7; the next step would be to cross out every 7th
     number in the list after 7, but they are all already crossed out at this point, as these numbers (14, 21, 28) are also multiples of smaller primes because 7 × 7 is greater than 30. The numbers not crossed out at this point in the list are all the
     prime numbers below 30:
     */
    public static int getNumberOfPrimeNumbersLessThanN(int n) {
        return 0;
    }
}
