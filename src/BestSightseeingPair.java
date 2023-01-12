import java.util.Arrays;

public class BestSightseeingPair {
    // brute force - TLE
    public static int maxScoreSightseeingPairBruteForce(int[] values) {
        int max = 0;
        int n = values.length;
        int[] maxScores = new int[n];
        Arrays.fill(maxScores, 0);
        for(int i=0; i < n; i++) {
            for(int j=i+1; j < n; j++) {
                maxScores[i] = Math.max(maxScores[i], values[i] + values[j] + (i-j));
            }
        }
        max = Arrays.stream(maxScores).max().getAsInt();
        return max;
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = 0;
        int maxLeft = values[0] + 0; // values[i] + i
        for(int i=1; i < n; i++) {
            int score = maxLeft + values[i] - i;
            maxScore = Math.max(maxScore, score);
            maxLeft = Math.max(maxLeft, values[i]+i);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int values[] = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
