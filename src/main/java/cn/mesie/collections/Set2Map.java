package cn.mesie.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 2018/10/6 20:51
 * 继承一个HashSet实现一个Map
 * @author: mesie
 */
public class Set2Map<K , V> extends HashSet<SimpleEntry<K , V>> {

    //实现清空key-value的方法
    public void clear(){
        super.clear();
    }

    //实现一个是否包含某一个key
    public boolean containsKey(K key){
        return super.contains(new SimpleEntry<K, V>(key,null));
    }

    //判断是否包含value
    public boolean containsValue(Object value){
        for(SimpleEntry<K , V> se: this){
            if(se.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    //根据key获取对应的value
    public V get(Object key){
        for(SimpleEntry<K , V> se: this){
            if(se.getKey().equals(key)){
                return se.getValue();
            }
        }
        return null;
    }

    //将指定的key-value放入集合
    public V put(K key, V value){
        add(new SimpleEntry<K, V>(key,value));
        return value;
    }

    //将一个Map的key-value放入集合
    public void putAll(Map<? extends K, ? extends V> m){
        for(K key : m.keySet()){
            add(new SimpleEntry<K, V>(key,m.get(key)));
        }
    }

    //将指定的key删除
    public V removeEntry(Object key){
        for(Iterator<SimpleEntry<K , V>> it = this.iterator(); it.hasNext();){
            SimpleEntry<K , V> en = (SimpleEntry<K ,V>)it.next();
            if(en.getKey().equals(key)){
                V v = en.getValue();
                it.remove();
                return v;
            }
        }
        return null;
    }

    //获取map的长度
    public int size(){
        return super.size();
    }


}
