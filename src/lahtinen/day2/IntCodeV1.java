package lahtinen.day2;

public class IntCodeV1 {

    public static int[] init(String input) {
        String[] split = input.split(",");
        int[] intcode = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            intcode[i] = Integer.parseInt(split[i]);
        }
        return intcode;
    }

    public static void execute(int[] memory) {
        int address = 0;
        while (address < memory.length) {
            if (memory[address] == 99) {
                return;
            }

            if (memory[address] == 1) {
                memory[memory[address + 3]] =
                        memory[memory[address + 1]] + memory[memory[address + 2]];
            } else if (memory[address] == 2) {
                memory[memory[address + 3]] =
                        memory[memory[address + 1]] * memory[memory[address + 2]];
            }
            address += 4;
        }
    }
}
