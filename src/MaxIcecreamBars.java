import java.util.Arrays;

public class MaxIcecreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        int icecreams = 0;
        Arrays.sort(costs);
        for(int i=0; i < costs.length; i++) {
            coins = coins - costs[i];
            if (coins >= 0) icecreams++;
            else break;
        }
        return icecreams;
    }

    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }
}
