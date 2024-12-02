import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day2 {
    public static void main(String[] args) {
        TextParser tx = new TextParser();
        String input = "";
        try {
            input = tx.readFromFile("day2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Convert to reports
        String[] reports = input.split(System.lineSeparator());
        /*int[] test = {71, 74, 77, 80, 83, 80, 83};
        System.out.println(Arrays.toString(test));
        System.out.println(isIncreasing(test));*/
        int safe = 0;
        for(int i = 0; i < reports.length; i++) {
            //Convert reports to int array
            int[] levels = Arrays.stream(reports[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            //System.out.println(Arrays.toString(levels));
            removeOneIndex(levels);
            if(isIncreasing(levels)) {
                safe++;
            }
            if(isDecreasing(levels)) {
                safe++;
            }
        }
        //System.out.println(safe);
    }
    public static boolean isIncreasing(int[] levels) {
        for (int i = 0; i < levels.length - 1; i++) {
            int previousNum = levels[i];
            int nextNum = levels[i + 1];
            int difference = nextNum - previousNum;

            // Check if the sequence is strictly increasing and the difference is valid
            if (previousNum >= nextNum || difference < 1 || difference > 3) {
                return false;

            }
        }
        return true;
    }
    public static boolean isDecreasing(int[] levels) {
        for (int i = 0; i < levels.length - 1; i++) {
            int previousNum = levels[i];
            int nextNum = levels[i + 1];
            int difference = nextNum - previousNum;

            // Check if the sequence is strictly increasing and the difference is valid
            if (previousNum <= nextNum || difference > -1 || difference < -3) {
                return false;
            }
        }
        return true;
    }
    //all unsafe test again with removing one index
    public static int[] removeOneIndex(int[] levels) {
        int[] newLevel = new int[levels.length - 1]; //Create new int arr with one length smaller
        System.out.println(Arrays.toString(levels));
        for(int i = 0; i < levels.length; i++) {
            int newIndex = 0;
            for(int j = 0; j < levels.length; j++) {
                if(j != i) {
                    newLevel[newIndex++] = levels[j];
                }
            }
            System.out.println(Arrays.toString(newLevel));
        }
        return newLevel;
    }
}
