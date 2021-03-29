public class LongestCommonPrefix {

    // Longest Common Prefix
    // Write a function to find the longest common prefix string amongst an array of strings.
    // If there is no common prefix, return an empty string "".
    public String longestCommonPrefix(String[] strs) {
        try {
            if (strs.length > 200 || strs[0].length() > 200) {
                return "";
            }

            String s = strs[0];
            int min = strs[0].length();

            // find the smallest word
            for(int i = 1; i < strs.length; i++) {
                if (min > strs[i].length()) {
                    min = strs[i].length();
                    s = strs[i];
                }
            }

            // check if the letters of the smallest string are contained within all words
            StringBuilder prefix = new StringBuilder();
            boolean flag = true;
            for(int i = s.length(); i >= 0; i--) {
                s = s.substring(0, i);
                for(int j = 0; j < strs.length; j++) {
                    if(!strs[j].substring(0, i).contains(s)) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if(flag) {
                    prefix.append(s);
                    break;
                }
            }

            return prefix.toString();
        } catch(Exception e) {
            return "";
        }
    }
}
