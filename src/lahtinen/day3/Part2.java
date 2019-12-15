package lahtinen.day3;

import lahtinen.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Part2 {
    public static void main(String... args) throws Exception {
        var rawPaths = Utils.fileToStringArray("src/lahtinen/day3/input.txt");
        var wire1Positions = getMap(rawPaths[0].split(","));
        var wire2Positions = getMap(rawPaths[1].split(","));

        int minSteps = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<PositionCounter>> e : wire1Positions.entrySet()) {
            Integer xPosition = e.getKey();
            for (PositionCounter positionCounter : e.getValue()) {
                if (wire2Positions.containsKey(xPosition) && wire2Positions.get(xPosition).contains(positionCounter)) {
                    int sum = wire2Positions.get(xPosition).get(wire2Positions.get(xPosition).indexOf(positionCounter)).counter + positionCounter.counter;
                    if (sum != 0 && sum < minSteps) {
                        minSteps = sum;
                    }
                }
            }
        }

        System.out.println("steps: " + minSteps);
    }

    private static Map<Integer, List<PositionCounter>> getMap(String[] wirePath) {
        var map = new HashMap<Integer, List<PositionCounter>>();
        int currentX = 0;
        int currentY = 0;

        int counter = 0;
        for (String direction : wirePath) {

            String dir = direction.substring(0, 1);
            int len = Integer.parseInt(direction.substring(1));
            final int startY = currentY;
            final int startX = currentX;

            switch (dir) {
                case "U":
                    while (currentY < startY + len) {
                        updateMap(map, currentX, currentY, counter++);
                        currentY++;
                    }
                    break;
                case "D":
                    while (currentY > startY - len) {
                        updateMap(map, currentX, currentY, counter++);
                        currentY--;
                    }
                    break;
                case "R":
                    while (currentX < startX + len) {
                        updateMap(map, currentX, currentY, counter++);
                        currentX++;
                    }
                    break;
                case "L":
                    while (currentX > startX - len) {
                        updateMap(map, currentX, currentY, counter++);
                        currentX--;
                    }
                    break;
            }
        }
        return map;
    }

    private static void updateMap(Map<Integer, List<PositionCounter>> map, int currentX, int currentY, int counter) {
        PositionCounter positionCounter = new PositionCounter(currentY, counter);
        if (map.containsKey(currentX)) {
            map.get(currentX).add(positionCounter);
        } else {
            map.put(currentX, new ArrayList<>(Collections.singletonList(positionCounter)));
        }
    }

    private static class PositionCounter {
        final int y;
        final int counter;

        PositionCounter(int y, int counter) {
            this.y = y;
            this.counter = counter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            PositionCounter positionCounter1 = (PositionCounter) o;
            return Objects.equals(y, positionCounter1.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(y);
        }
    }
}
