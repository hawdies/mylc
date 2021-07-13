package lc;

import java.util.*;

/**
 * description: 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 *
 * 思路: 扫描线 + 优先队列
 * 注意点: 1. 将每个端点对应的(x,y)坐标放入优先队列queue中,左端点的y值为负的height,右端点为正height.(这样做一是为了区分左右端点,二是在x相同的情况下,左端点会在队列前面)
 * eg.[[0,2,3], [2, 5, 3]], 按照上述定义,queue队列的值为[0, -3], [2, -3], [2, 3], [5, 3] ==> 结果为[0, 3], [5, 0]
 * 如果队列queue只按照x排序,而不考虑y,则queue队列为[0, -3], [2, 3], [2, -3], [5, 3] ==> 结果为[0,3], [2, 0], [2, 3], [5, 0]
 *
 * 2. 使用curPointHeights优先队列存放当前端点x所有的height值,并按降序排列. 如果当前point(x, y)是左端点则加入curPointHeights,右端点则删除.
 * 同时使用lastpoint存放上一个端点,如果上一个端点的height和当前端点的高度不同则加入当前端点,否则不加入.
 * @author hawdies
 * @date 2021/7/13
 **/
public class N218TheSkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        N218TheSkylineProblem demo = new N218TheSkylineProblem();
        List<List<Integer>> skyline = demo.getSkyline(buildings);
        System.out.println(skyline);
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        for (int[] building : buildings) {
            int[] leftPoint = new int[2];
            leftPoint[0] = building[0];
            leftPoint[1] = -building[2];
            int[] rightPoint = new int[2];
            rightPoint[0] = building[1];
            rightPoint[1] = building[2];
            queue.add(leftPoint);
            queue.add(rightPoint);
        }
        PriorityQueue<Integer> curPointHeights = new PriorityQueue<>((a, b) -> b - a);
        curPointHeights.offer(0);
        int[] lastpoint = {0, 0};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point[1] < 0) {
                curPointHeights.offer(-point[1]);
            } else {
                curPointHeights.remove(point[1]);
            }
            Integer height = curPointHeights.peek();
            height = height == null ? 0 : height;
            if (height != lastpoint[1]) {
                lastpoint[0] = point[0];
                lastpoint[1] = height;
                result.add(Arrays.asList(lastpoint[0], lastpoint[1]));
            }
        }
        return result;
    }
}
