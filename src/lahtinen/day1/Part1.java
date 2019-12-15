package lahtinen.day1;

import lahtinen.Utils;

import java.util.stream.Stream;

public class Part1 {
    public static void main(String... args) throws Exception {
        int result = Stream.of(Utils.fileToStringArray("src/lahtinen/day1/input.txt"))
                .map(Integer::valueOf)
                .mapToInt(v -> (v / 3) - 2)
                .sum();
        System.out.println(result);
    }
}
