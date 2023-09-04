public class SmallestNumN {

    public static void main(String args[]) {
        // Calling the smallest method with an input integer of 81000
        System.out.println(smallest(81000));
    }

    static int smallest(int n) {
        // Initialize an empty string to store the answer
        String ans = "";

        // Loop through potential divisors from 9 down to 2
        for (int div = 9; div >= 2; div--) {
            // Keep dividing 'n' by the current divisor as long as it's divisible
            while (n % div == 0) {
                n /= div; // Divide 'n' by the divisor
                // smallest factors appended first
                ans = div + ans; // Append the divisor to the answer string
            }
        }

        // If 'n' is not equal to 1, it means there are remaining prime factors (>9)
        if (n != 1) {
            return -1; // Unable to construct the number, return -1
        } else {
            // Convert the answer string to an integer and return it
            return Integer.parseInt(ans);
        }
    }
}
