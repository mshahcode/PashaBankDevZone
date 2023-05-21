package scoretracker;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> result = new ArrayList<>();
        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        int maxCount = 0;
        int minCount = 0;

        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score > maxScore) {
                maxScore = score;
                maxCount++;
            } else if (score < minScore) {
                minScore = score;
                minCount++;
            }
        }

        result.add(maxCount);
        result.add(minCount);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> scores = List.of(15, 10, 12, 18, 20, 25, 22, 28, 16, 14);
        List<Integer> result = breakingRecords(scores);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
