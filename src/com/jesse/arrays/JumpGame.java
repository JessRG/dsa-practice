package com.jesse.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JumpGame {
    InputStream inputStream = getClass().getResourceAsStream("input.properties");
    public static void main(String[] args) throws IOException {
        JumpGame jg = new JumpGame();

        int[] arr;
        Properties properties = new Properties();
        properties.load(jg.inputStream);
        Pattern pattern = Pattern.compile("(?<=\\[)(.*?)(?=\\])");
        Matcher matcher = pattern.matcher(properties.getProperty("arr0"));
//        Matcher matcher = pattern.matcher(properties.getProperty("arr1"));
//        Matcher matcher = pattern.matcher(properties.getProperty("arr2"));
//        Matcher matcher = pattern.matcher(properties.getProperty("arr3"));
//        Matcher matcher = pattern.matcher(properties.getProperty("arr4"));
//        Matcher matcher = pattern.matcher(properties.getProperty("arr5"));
//        Matcher matcher = pattern.matcher(properties.getProperty("arr6"));

        if (matcher.find()) {
            String[] inputs = matcher.group().split(",");
            arr = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
            System.out.println(canJump(arr));
        }
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int len = nums.length - 1;
        int idx = 0;
        Stack<Integer[]> stk = new Stack<>();
        boolean[] visited = new boolean[nums.length];
        stk.push(new Integer[] { idx, nums[idx] });

        while (!stk.isEmpty()) {
            Integer[] indices = stk.pop();
            int i = indices[0];
            int jump = indices[1];

            if (i + jump >= len) {
                return true;
            } else {
                visited[i] = true;
                for (int pos = i+1; pos <= i + jump; pos++) {
                    if (nums[pos] != 0 && !visited[pos]) {
                        stk.push(new Integer[] {pos, nums[pos]});
                    }
                }
            }
        }
        return false;
    }

//    private static boolean jump(int[] nums, int idx, int val, int len) {
//        if (idx + val >= len) {
//            return true;
//        } else {
//            for (int i = idx + 1; i <= idx + val; i++) {
//                if (jump(nums, i, nums[i], len)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
}
