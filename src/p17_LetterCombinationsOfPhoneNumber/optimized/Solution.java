package p17_LetterCombinationsOfPhoneNumber.optimized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> letterCombinations(String digits) {

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        res.add("");

        for (char digit : digits.toCharArray()) {

            List<String> newRes = new ArrayList<>();

            for (String current : res) {

                for (char letter : map.get(digit).toCharArray()) {
                    newRes.add(current + letter);
                }
            }

            res = newRes;
        }

        return res;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.letterCombinations("23"));
        System.out.println(sol.letterCombinations("2"));
    }
}