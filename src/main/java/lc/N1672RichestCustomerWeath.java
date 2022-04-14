package lc;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2022/4/14
 */
public class N1672RichestCustomerWeath {
    public int maximumWealth(int[][] accounts) {
        int[] customers = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                customers[i] += accounts[i][j];
            }
        }
        int maxWeath = 0;
        for (int weath : customers) {
            maxWeath = Math.max(maxWeath, weath);
        }
        return maxWeath;
    }
}
