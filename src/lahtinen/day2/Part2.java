package lahtinen.day2;

import lahtinen.Utils;

public class Part2 {

    public static void main(String... args) throws Exception {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                int[] intcode = IntCodeV1.init(Utils.fileToString("src/lahtinen/day2/input.txt"));
                intcode[1] = noun;
                intcode[2] = verb;
                IntCodeV1.execute(intcode);
                if (intcode[0] == 19690720) {
                    System.out.println("Result: " + (100 * noun + verb));
                    return;
                }
            }
        }
    }
}
