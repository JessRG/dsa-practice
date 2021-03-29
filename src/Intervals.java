import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Intervals {

    // Merge Intervals
    // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    // and return an array of the non-overlapping intervals that cover all the intervals in the input.
    public static int[][] merge(int[][] intervals) {
        // check intervals length
        if(intervals.length == 0) return new int[0][0];

        // Declare ArrayList to store the combined intervals
        List<int[]> merge = new ArrayList<>();

        // sort the intervals before merging/combining overlapping intervals (using lambda expression to handle the comparator)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // store the start and end of the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // iterate through the intervals in the intervals array
        for(int i = 1; i < intervals.length; i++) {
            // write logic for each iteration
            // set currStart and currEnd to the interval currently being iterated through
            // declare current start and end variable for each interval within the array
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            // check if the current start is less than or equal to the end of the previous interval
            if(currStart <= end) {
                // don't update the start
                // update the end (use max method to find the higher value of first interval end and current interval end)
                end = Math.max(currEnd, end);
            } else {
                // add the merged interval to the list
                merge.add(new int[] {start, end});

                // update(reset to current) start and end
                start = currStart;
                end = currEnd;
            }
        }
        // need to add in the last interval to the list
        merge.add(new int[] {start, end});
        return merge.toArray(new int[merge.size()][]);
    }

    // Interval List Intersections
    public static int[][] intervalIntersection(int[][] A, int[][] B) {

//        int[][] a = new int[][] { {0,2}, {5,10}, {13,23}, {24,25} };
//        int[][] b = new int[][] { {1,5}, {8,12}, {15,24}, {25,26} };

        // List to store the interval intersections
        List<int[]> intersections = new ArrayList<>();

        // set the start and end
        // set two int variables as pointers: one for A and one for B
        int a = 0;
        int b = 0;

        // iteration through the intervals --> while loop
        while(a < A.length && b < B.length) {
            int startA = A[a][0], endA = A[a][1];
//            System.out.println("startA: " + startA+ " endA: " + endA);
            int startB = B[b][0], endB = B[b][1];
//            System.out.println("startB: " + startB+ " endB: " + endB);

            // current values
            // maximum between both A and B start of intervals
            // minimum between both A and B end of intervals
            int start = Math.max(startA, startB);
            int end = Math.min(endA, endB);

            // compare current start with current end
            if(start <= end) {
                // add the intersection interval of A and B intervals to the list
                intersections.add(new int[] {start, end});
            }

            // increment either a or b minimum endpoint to the next interval (since minimum point is stored as end)
            if(endA < endB) a++;
            else b++;
        }

        // return intersections
        return intersections.toArray(new int[intersections.size()][]);
    }
}
