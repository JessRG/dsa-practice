public class Recursion {
    public int countZeros(int n) {
        return helper(n, 0);
    }

    public int helper(int n, int c) {
        if (n == 0) {
            return c;
        }

        if (n % 10 == 0) {
            c++;
        }
        return helper(n/10, c);
    }
}
