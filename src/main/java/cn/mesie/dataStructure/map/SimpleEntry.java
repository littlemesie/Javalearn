package cn.mesie.dataStructure.map;

import java.util.Map;

/**
 * Created by 2018/10/6 20:38
 * 重新定义一个SimpleEntry
 * @author: mesie
 */
public class SimpleEntry<K , V> implements Map.Entry<K , V>, java.io.Serializable{

    private K key;
    private V value;


    public SimpleEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o.getClass() == SimpleEntry.class){
            SimpleEntry se = (SimpleEntry) o;
            return se.getKey().equals(getKey());
        }
        return false;
    }

    //根据key计算hashCode
    public int hashCode(){
        return key == null ? 0:key.hashCode();
    }


    public String toString() {
        return key + "=" + value;
    }
}
