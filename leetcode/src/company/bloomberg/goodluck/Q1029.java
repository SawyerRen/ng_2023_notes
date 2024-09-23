package company.bloomberg.goodluck;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1029 {
    // O(nlogn)
    public int twoCitySchedCost(int[][] costs) {
        //假设所有人都先去A
        int minCost = 0;
        int n = costs.length / 2;
        int[] priceGap = new int[costs.length];
        int index = 0;

        for(int[] cost : costs){
            minCost += cost[0];
            //计算去A和去B的差价
            priceGap[index++] = cost[1] - cost[0]; //if > 0
        }
 
        //排序差价：去B比较便宜的 选一半 if < 0
        Arrays.sort(priceGap);

        for(int i = 0; i < n; i++){
            minCost += priceGap[i];
        }
        
        return minCost;
    }
}
