package zs;

/**
 * description: 给你一个 严格递增 的整数数组 rungs ，用于表示梯子上每一台阶的 高度 。当前你正站在高度为 0 的地板上，并打算爬到最后一个台阶。
 * 另给你一个整数 dist 。每次移动中，你可以到达下一个距离你当前位置（地板或台阶）不超过 dist 高度的台阶。当然，你也可以在任何正 整数 高度处插入尚不存在的新台阶。
 * 返回爬到最后一阶时必须添加到梯子上的 最少台阶数。
 *
 * @author hawdies
 * @date 2021/7/18
 **/
public class N5814AddMinmumNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
        int pos = 0;
        int addRungs = 0;
        for (int rung : rungs) {
            int diff = rung - pos;
            int count = diff / dist;
            addRungs += count;
            pos = rung;
        }
        return addRungs;
    }
}
