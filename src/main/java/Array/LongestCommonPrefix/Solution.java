package Array.LongestCommonPrefix;

import java.util.ArrayList;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        if (strs.length == 1) {
            return strs[0];
        }

        int maxLengthPrefix = strs.length <= 0 ? 0 : strs[0].length();

        if (maxLengthPrefix == 0) {
            return "";
        } else {
            ArrayList<char[]> formatedList = new ArrayList<char[]>();

            for (String s : strs) {
                if (s.length() < maxLengthPrefix) {
                    maxLengthPrefix = s.length();
                }
            }

            for (String s : strs) {
                if (s.length() > maxLengthPrefix) {
                    formatedList.add(s.substring(0, maxLengthPrefix).toCharArray());
                } else {
                    formatedList.add(s.toCharArray());
                }
            }

            ArrayList<Character> listForCompare = new ArrayList<Character>();

            for (int i = 0; i < maxLengthPrefix; i++) {
                for (int j = 0; j < formatedList.size(); j++) {
                    listForCompare.add(formatedList.get(j)[i]);
                }

                boolean isTake = false;
                char temp = listForCompare.get(0);
                for (int a = 1; a < listForCompare.size(); a++) {
                    if (listForCompare.get(a).equals(temp)) {
                        isTake = true;
                    } else {
                        isTake = false;
                        break;
                    }
                }

                if (isTake) {
                    sb.append(temp);
                } else {
                    break;
                }
                listForCompare = new ArrayList<Character>();
            }
        }

        return sb.toString();
    }
}