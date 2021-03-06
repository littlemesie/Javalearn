package cn.mesie.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 2019-04-27 22:59
 *
 * @author: mesie
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 5);
        map.put("2", 6);
        map.put("3", 7);
        map.put("4", 8);

        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> next = entryIterator.next();
            System.out.println("key=" + next.getKey() + " value=" + next.getValue());
        }
        System.out.println("=============");

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key=" + key + " value=" + map.get(key));

        }

        System.out.println("=============");
        for(String key : map.keySet()){
            System.out.println("key=" + key + " value=" + map.get(key));

        }

    }
}
