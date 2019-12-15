package lahtinen.day4;

public class Part1 {
    public static void main(String... args) {
        System.out.println("Num passwords: " + findNumPasswords(273025, 767253));
    }

    private static int findNumPasswords(int start, int finish) {
        int result = 0;
        int current = start;
        while (current != finish) {
            char[] numberSeries = String.valueOf(current).toCharArray();
            if (isIncreasing(numberSeries)) {
                if (isPair(numberSeries)) {
                    result++;
                }
            }
            current++;
        }
        return result;
    }

    private static boolean isIncreasing(char[] numberSeries) {
        for (int i = 0; i < numberSeries.length - 1; i++) {
            if (numberSeries[i] > numberSeries[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPair(char[] numberSeries) {
        for (int i = 0; i < numberSeries.length - 1; i++) {
            if (numberSeries[i] == numberSeries[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
