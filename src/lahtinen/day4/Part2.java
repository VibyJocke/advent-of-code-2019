package lahtinen.day4;

import java.util.HashMap;

public class Part2 {
    public static void main(String... args) {
        System.out.println("Num passwords: " + findNumPasswords(273025, 767253));
    }

    private static int findNumPasswords(int start, int finish) {
        int result = 0;
        int current = start;
        while (current != finish) {
            char[] numberSeries = String.valueOf(current).toCharArray();
            if (isIncreasing(numberSeries)) {
                if (isTruePair(numberSeries)) {
                    result++;
                }
            }
            current++;
        }
        return result;
    }

    private static boolean isIncreasing(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isTruePair(char[] numberSeries) {
        var foundNumbers = new HashMap<Integer, Integer>();
        for (char number : numberSeries) {
            int asInt = Character.getNumericValue(number);
            foundNumbers.putIfAbsent(asInt, 0);
            foundNumbers.computeIfPresent(asInt, (k, v) -> v + 1);
        }
        return foundNumbers.containsValue(2);
    }
}
