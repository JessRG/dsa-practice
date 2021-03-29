import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // Pascal's Triangle
    // Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    public static List<List<Integer>> generate(int numRows) {

        final List<List<Integer>> pascalsT = new ArrayList<>();

        // define the logic to generate pascal's triangle
        if(numRows == 0) return pascalsT;

        // add a new arraylist to pascal's triangle list
        pascalsT.add(new ArrayList<>());

        // set first row as 1
        pascalsT.get(0).add(1);

        for(int rowNum = 1; rowNum < numRows; rowNum++) {
            // Declare local list to build following rows
            List<Integer> row = new ArrayList<>();
            // Declare local list reference to reference previous row
            List<Integer> prevRow = pascalsT.get(rowNum - 1);

            // first row element will always be 1.
            row.add(1);

            // each element between the first and last is equal to the
            // sum of the elements above-and-to-the-left and above-and-to-the-right.
            for(int i = 1; i < rowNum; i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            // last row element will always be 1.
            row.add(1);

            // add the row to the triangle
            pascalsT.add(row);
        }
        // return pascal's triangle
        return pascalsT;
    }
}
