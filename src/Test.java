import java.util.*;

public class Test {
    public static void main(String[] args) {
        LeetcodeList lcList = new LeetcodeList();
//        System.out.println(Arrays.toString(lcList.twoSum(new int[] {2,7,11,15}, 9)));
//        System.out.println(Arrays.toString(lcList.twoSum(new int[] {3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(lcList.twoSum(new int[] {3, 3}, 6)));

//        System.out.println(lcList.longestCommonPrefix(new String[] { "flower","flow","flight" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "dog","racecar","car" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "hello","hell","helenor" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "a" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "reflower", "flow", "flight" }));

//        System.out.println(lcList.isValid("()"));
//        System.out.println(lcList.isValid("()[]{}"));
//        System.out.println(lcList.isValid("(]"));
//        System.out.println(lcList.isValid("([)]"));
//        System.out.println(lcList.isValid("{[]}"));
//        System.out.println(lcList.isValid("(){[]}"));
//        System.out.println(lcList.isValid("{[]}()"));
//        System.out.println(lcList.isValid("(}{[]}[}"));
//        System.out.println(lcList.isValid("[](])"));

        int[] arr = new int[] { 1,1,2 };
        arr = new int[] { 0,0,1,1,1,2,2,3,3,4 };
        arr = new int[] { -3,-1,0,0,0,3,3 };
        int len = lcList.removeDuplicates(arr);
        System.out.print(len + ", [");
        for(int i = 0; i < len; i++) {
            if (i == len - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

}
