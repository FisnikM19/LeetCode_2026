package p17_LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> lettersOf2 = new ArrayList<>();
        lettersOf2.add("a");
        lettersOf2.add("b");
        lettersOf2.add("c");

        List<String> lettersOf3 = new ArrayList<>();
        lettersOf3.add("d");
        lettersOf3.add("e");
        lettersOf3.add("f");

        List<String> lettersOf4 = new ArrayList<>();
        lettersOf4.add("g");
        lettersOf4.add("h");
        lettersOf4.add("i");

        List<String> lettersOf5 = new ArrayList<>();
        lettersOf5.add("j");
        lettersOf5.add("k");
        lettersOf5.add("l");

        List<String> lettersOf6 = new ArrayList<>();
        lettersOf6.add("m");
        lettersOf6.add("n");
        lettersOf6.add("o");

        List<String> lettersOf7 = new ArrayList<>();
        lettersOf7.add("p");
        lettersOf7.add("q");
        lettersOf7.add("r");
        lettersOf7.add("s");

        List<String> lettersOf8 = new ArrayList<>();
        lettersOf8.add("t");
        lettersOf8.add("u");
        lettersOf8.add("v");

        List<String> lettersOf9 = new ArrayList<>();
        lettersOf9.add("w");
        lettersOf9.add("x");
        lettersOf9.add("y");
        lettersOf9.add("z");

        List<List<String>> mergeLists = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            switch (c) {
                case '2':
                    mergeLists.add(lettersOf2);
                    break;
                case '3':
                    mergeLists.add(lettersOf3);
                    break;
                case '4':
                    mergeLists.add(lettersOf4);
                    break;
                case '5':
                    mergeLists.add(lettersOf5);
                    break;
                case '6':
                    mergeLists.add(lettersOf6);
                    break;
                case '7':
                    mergeLists.add(lettersOf7);
                    break;
                case '8':
                    mergeLists.add(lettersOf8);
                    break;
                case '9':
                    mergeLists.add(lettersOf9);
                    break;
                default:
                    break;
            }

        }

        List<String> res = new ArrayList<>();
        res.add("");

        for (List<String> list : mergeLists) {

            List<String> newRes = new ArrayList<>();

            for (String current : res) {
                for (String letter : list) {
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
