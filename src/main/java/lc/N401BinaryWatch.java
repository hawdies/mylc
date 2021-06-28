package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧.
 *
 * 思路: 穷举求解
 * @author hawdies
 * @date 2021/6/21
 **/
public class N401BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    String str = h + ":" + String.format("%02d", m);
                    list.add(str);
                }
            }
        }
        return list;
    }
}
