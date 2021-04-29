package wangyi.solution01;

/**
 * @author hawdies
 * @date 2021/4/18
 **/
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算HR需要准备的神秘大奖数量
     *
     * @param person_cards char字符型一维数组 每位同学手上卡片列表
     * @param hide_cards   char字符型一维数组 待搜寻的卡片列表
     * @return int整型
     */
    public int solve(char[] person_cards, char[] hide_cards) {
        // write code here
        int[] array = new int[4];
        for (int i = 0; i < person_cards.length; i++) {
            if (person_cards[i] == 'N') array[0]++;
            else if (person_cards[i] == 'T') array[1]++;
            else if (person_cards[i] == 'E') array[2]++;
            else if (person_cards[i] == 'S') array[3]++;
        }
        for (int i = 0; i < hide_cards.length; i++) {
            if (hide_cards[i] == 'N') array[0]++;
            else if (hide_cards[i] == 'T') array[1]++;
            else if (hide_cards[i] == 'E') array[2]++;
            else if (hide_cards[i] == 'S') array[3]++;
        }

        int res = Math.min(array[0], Math.min(array[1], Math.min(array[2], array[3])));
        return res;
    }
}
