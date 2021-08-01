package kuaipai;

import java.util.*;

public class FrequencySort {
    public static String frequencySort(String s) {

        if (s.length() < 3){
            return s;
        }

        //查找表（将数据存到一个表里，然后查找）map查找比list更优（更适合查找）
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        //通过Arraylist构造函数把map.entrySet()转化为list(map没有按值排序的方法，我们要把map转化为list)
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(counter.entrySet());
        //用Comparator比较器进行排序
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                //从大到小逆序排序
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        StringBuilder res = new StringBuilder();
        //遍历排好序的列表，得到排好序的集合，然后按值遍历，将键key放到res中，输出字符串）
        for (Map.Entry<Character, Integer> entry : list) {
            //对每一个值进行遍历，例如a出现三次,遍历3次，将a加入res，e出现2词，遍历2次,将e加入res......
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        String str = "traaaeeawe";
        System.out.print(frequencySort(str));
    }
}
