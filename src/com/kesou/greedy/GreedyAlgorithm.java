package com.kesou.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放到hashMap中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入map
        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        //存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArraysList,存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中电台覆盖的地区和当前还没有覆盖的地区交集
        HashSet<String> tempSet = new HashSet<String>();

        //定义一个maxKey,保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的Key
        //如果maxKey不为null,则会加入到selects
        String maxKey = null;
        while (allAreas.size() != 0) {//如果allAreas不为0，则表示还没有覆盖到所有地区
            //每进行一次while需要
            maxKey = null;

            //遍历broadcasts,取出对应key
            for (String key : broadcasts.keySet()) {
                //每进行一次for
                tempSet.clear();
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖的地区的数量，比maxKey指向的集合未覆盖的地区还要多
                //就需要重置maxKey
                //体现贪心算法优点，每次选最优
                if (tempSet.size() > 0
                        && (maxKey == null || tempSet.size()
                        > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //maxKey != null,就应该将maxKey 加入selects
            if (maxKey!=null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果是"+selects);
    }
}
