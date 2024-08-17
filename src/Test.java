import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
//        Steps ns = new Steps();
//        System.out.println(ns.numberOfSteps(8));
//        List<Integer> a = new ArrayList<>(List.of(new Integer[]{1, 1, 0, -1, -1}));

//        ProductsOfArrayExceptSelf test = new ProductsOfArrayExceptSelf();
//        int[] arr = test.productExceptSelf(a);
//        System.out.println(Arrays.toString(arr));

//        plusMinus(a);

        List<Integer> b = new ArrayList<>(List.of(new Integer[] { 1, 2, 3, 4, 5}));
        miniMaxSum(b);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        if (arr.isEmpty()) {
            return;
        }
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });

        Integer s = 0;
        Integer e = arr.size() - 1;
        long minSum = 0;
        long maxSum = 0;

        while (s < arr.size() - 1 && e > 0) {
            if(arr.get(s) <= 0) {
                return;
            } else {
                minSum += arr.get(s);
                s++;
                maxSum += arr.get(e);
                e--;
            }
        }

        System.out.println(minSum + " " + maxSum);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        float posCount = 0;
        float negCount = 0;
        float zeroCount = 0;

        for (Integer elem : arr) {
            if (elem > 0) {
                posCount++;
            } else if (elem < 0) {
                negCount++;
            } else {
                zeroCount++;
            }
        }

        float len = arr.size();
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(posCount/len));
        System.out.println(df.format(negCount / len));
        System.out.println(df.format(zeroCount / len));
    }

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribeCount = 0;
        boolean isChaotic = false;

        for (int i = 0; i < q.size(); i++) {
            for(int j = 0; j < q.size(); j++) {
                int bribe = q.get(j) - (j+1);
                if (bribe > 2) {
                    isChaotic = true;
                    break;
                }
            }

            if (isChaotic) {
                break;
            }

            for (int j = 1; j <= q.size() - 1 - i; j++) {
                if (q.get(j) < q.get(j-1)) {
                    swap(q, j-1, j);
                    bribeCount++;
                }
            }
        }
        System.out.println(isChaotic ? "Too chaotic" : bribeCount);
    }

    public static void swap(List<Integer> arr, int first, int second) {
        int temp = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, temp);
    }
}
