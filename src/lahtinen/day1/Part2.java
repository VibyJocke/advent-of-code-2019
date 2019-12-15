package lahtinen.day1;

import lahtinen.Utils;

import java.util.stream.Stream;

public class Part2 {
    public static void main(String... args) throws Exception {
        int totalFuel = Stream.of(Utils.fileToStringArray("src/lahtinen/day1/input.txt"))
                .map(Integer::valueOf)
                .mapToInt(Part2::calculateFuelRequirement)
                .sum();
        System.out.println("Total fuel:  " + totalFuel);
    }

    private static int calculateFuelRequirement(int mass) {
        int newMass = (mass / 3) - 2;
        return newMass > 0 ? newMass + calculateFuelRequirement(newMass) : 0;
    }
}