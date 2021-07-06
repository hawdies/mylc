package lc;

import java.util.*;

/**
 * description: 给你一个数组 orders，表示客户在餐厅中完成的订单，
 * 确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表。
 * 在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
 * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 * 思路: 遍历orders, 然后setOrder集和存储菜单的字典排序, setTable存储桌号的升序, Map&lt;Integer, Map&lt;String, Integer&gt;&gt;用来存储每张桌子所点菜单
 * @author hawdies
 * @date 2021/7/6
 **/
public class N1418DispalyTableOfFood {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // 菜单集合字典排序
        Set<String> setOrder = new TreeSet<>(String::compareTo);
        // 桌号升序
        Set<Integer> setTable = new TreeSet<>(Integer::compareTo);
        // k -> 桌号; v -> submap(k, v), k -> 点单的食物名称,v -> 数量
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (List<String> list : orders) {
            String foodItem = list.get(2);
            setOrder.add(foodItem);
            Integer table = Integer.parseInt(list.get(1));
            setTable.add(table);
            Map<String, Integer> curMap = map.getOrDefault(table, new HashMap<>());
            curMap.put(foodItem, curMap.getOrDefault(foodItem, 0) + 1);
            map.put(table, curMap);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(setOrder);
        result.add(head);
        for (Integer table : setTable) {
            List<String> list = new ArrayList<>();
            list.add(table.toString());
            Map<String, Integer> curMap = map.get(table);
            for (String foodItem : setOrder) {
                Integer foodNum = curMap.getOrDefault(foodItem, 0);
                list.add(foodNum.toString());
            }
            result.add(list);
        }

        return result;
    }
}
