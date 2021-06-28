package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hawdies
 * @Date 2021/3/23
 **/
public class N128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLength = 1;
        int currentLength = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        return maxLength;
    }

    public int bySet(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
            set.add(e);
        }
        int maxLength = 1;
        int currentLength = 1;
        for (Integer e : set) {
            if (!set.contains(e - 1)) {
                for(int i = 1; ; i++) {
                    if (set.contains(e + i)) {
                        currentLength++;
                    } else {
                        maxLength = Math.max(maxLength, currentLength);
                        currentLength = 1;
                        break;
                    }
                }
            }
        }
        return maxLength;
    }
}
