import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactor {

    public static int[] addX(int n, int arr[], int x) {
        int newarr[] = new int[n + 1];
        for (int i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public static int[] get_prime_factors(int number){
        int[] prime_factors = {};
        while (number % 2 == 0) {
            prime_factors = addX(prime_factors.length, prime_factors, 2);
            number = number / 2;
        }
        for (int i = 3; i < Math.sqrt(number); i = i + 2) {
            while (number % i == 0) {
                prime_factors = addX(prime_factors.length, prime_factors, i);
                number = number / i;
            }
        }

        if (number > 2)
            prime_factors = addX(prime_factors.length, prime_factors, number);

        return prime_factors;
    }
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        System.out.println("Enter a number you want the prime factors of. ");
        int number = getNum.nextInt();

        int[] prime_factors = get_prime_factors(number);
        System.out.println("Prime Factors of " + number + ": "+ Arrays.toString(prime_factors));
    }
}
