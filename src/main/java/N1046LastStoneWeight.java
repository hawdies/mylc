import java.util.PriorityQueue;

/**
 * description: 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 思路: 使用优先队列求解,按照降序排序
 *
 * @author hawdies
 * @date 2021/6/8
 **/
public class N1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.size() == 1) return priorityQueue.remove();
            int a = priorityQueue.remove();
            int b = priorityQueue.remove();
            if (a != b) {
                priorityQueue.add(a - b);
            }
        }
        return 0;
    }
}
