package lahtinen.day3;

import lahtinen.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {
    public static void main(String... args) throws Exception {
        var rawPaths = Utils.fileToStringArray("src/lahtinen/day3/input.txt");
        var wire1Positions = getMap(rawPaths[0].split(","));
        var wire2Positions = getMap(rawPaths[1].split(","));

        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> e : wire1Positions.entrySet()) {
            Integer xPos = e.getKey();
            for (Integer integer : e.getValue()) {
                if (wire2Positions.containsKey(xPos) && wire2Positions.get(xPos).contains(integer)) {
                    int manhattanDistance = Math.abs(-xPos) + Math.abs(-integer);
                    if (manhattanDistance != 0 && manhattanDistance < minDistance) {
                        minDistance = manhattanDistance;
                    }
                }
            }
        }

        System.out.println("distance: " + minDistance);
    }

    private static Map<Integer, List<Integer>> getMap(String[] wirePath) {
        var map = new HashMap<Integer, List<Integer>>();
        int currentX = 0;
        int currentY = 0;

        for (String direction : wirePath) {
            final String dir = direction.substring(0, 1);
            final int len = Integer.parseInt(direction.substring(1));
            final int startY = currentY;
            final int startX = currentX;

            switch (dir) {
                case "U":
                    while (currentY < startY + len) {
                        updateMap(map, currentX, currentY);
                        currentY++;
                    }
                    break;
                case "D":
                    while (currentY > startY - len) {
                        updateMap(map, currentX, currentY);
                        currentY--;
                    }
                    break;
                case "R":
                    while (currentX < startX + len) {
                        updateMap(map, currentX, currentY);
                        currentX++;
                    }
                    break;
                case "L":
                    while (currentX > startX - len) {
                        updateMap(map, currentX, currentY);
                        currentX--;
                    }
                    break;
            }
        }
        return map;
    }

    private static void updateMap(Map<Integer, List<Integer>> map, int currentX, int currentY) {
        if (map.containsKey(currentX)) {
            map.get(currentX).add(currentY);
        } else {
            map.put(currentX, new ArrayList<>(Collections.singleton(currentY)));
        }
    }
}
