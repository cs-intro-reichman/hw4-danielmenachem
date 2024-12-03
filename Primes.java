public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); 
        primesPrint(n);
    }


    /**  a function that recieves an integer input (n) and prints all the prime numbers in the range 0-n. 
    */
    public static void primesPrint (int n) {
        int[] primes = primesFinder(n); 
        int primeCount = primes.length; 
        int percent = (int) (((double) primeCount / (double) n) * 100.00);
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 0; i < primes.length; i++) {
            System.out.println(primes[i]);
        }
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + percent + "% are primes)");
    }
    

    /** a function that recieves an integer input (n) and returns an int array, consists of the prime numbers in the range 0-n. 
    */
    public static int[] primesFinder (int n) {
        boolean[] primeTrue = primesAreTrue(n); 
        int[] output = trueIndexArr(primeTrue, 0); 
        return output; 
    }
    

    /** a function that counts how many of a boolean array values are 'true', starting from index x. 
    */
    public static int trueCounter (boolean[] booleanArr, int x) {
        int trueCount = 0; 
        for (int i = x; i < booleanArr.length; i++) {
            if (booleanArr[i]) {
                trueCount ++; 
            }
        }
        return trueCount; 
    }


    /** a function that creats an int array out of the inedxes of the 'true' values in a boolean array, starting from index x. 
    */ 
    public static int[] trueIndexArr (boolean[] booleanArr, int x) {
        int arraySize = trueCounter(booleanArr, x); 
        int[] output = new int[arraySize]; 
        int j = 0;
        for (int i = x; i < booleanArr.length; i++) {
            if (booleanArr[i]) {
                output[j] = i; 
                j++; 
            }
        }
        return output; 
    }


    /** a function that returns a boolean array at size n+1 such that prime indexes are true and coprime indexes are false. 
    * (check which numbers are prime in the range 2-n).
    */ 
    public static boolean[] primesAreTrue (int n) {
        boolean[] output = new boolean[n + 1]; 
        // setting all the elements as 'true'. later on we will illuminate the coprime indexed elements.
        for (int i = 0; i < n + 1; i++) {
            output[i] = true; 
        }
         if (n > 0) { output[0] = false; }
         if (n > 1) { output[1] = false; } 
        output[1] = false; 
        int j = 2; 
        while (j <= Math.sqrt(n)) {
            if (output[j]) {
                int k = 2; 
                while (k * j <= n) {
                    output [k * j] = false; 
                    k++; 
                }
                j++; 
            }
            if (!output[j]) {
                j++; 
            }
        }
        return output;
    }


}