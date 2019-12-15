package lahtinen.day2;

import lahtinen.Utils;

public class Part1 {

    public static void main(String... args) throws Exception {
        int[] intcode = IntCodeV1.init(Utils.fileToString("src/lahtinen/day2/input.txt"));
        intcode[1] = 12;
        intcode[2] = 2;
        IntCodeV1.execute(intcode);
        System.out.println("Answer: " + intcode[0]);
    }
}
