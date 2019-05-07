# ThreadLocalMap源码解析
    
- ThreadLocalMap是一个自定义的hash map，专门用来保存线程的thread local变量

- 它的操作仅限于ThreadLocal类中，不对外暴露

- 这个类被用在Thread类的私有变量threadLocals和inheritableThreadLocals上

- 为了能够保存大量且存活时间较长的threadLocal实例，hash table entries采用了WeakReferences作为key的类型

- 一旦hash table运行空间不足时，key为null的entry就会被清理掉

```java
 1static class ThreadLocalMap {
 2
 3    // hash map中的entry继承自弱引用WeakReference，指向threadLocal对象
 4    // 对于key为null的entry，说明不再需要访问，会从table表中清理掉
 5    // 这种entry被成为“stale entries”
 6    static class Entry extends WeakReference<ThreadLocal<?>> {
 7        /** The value associated with this ThreadLocal. */
 8        Object value;
 9
10        Entry(ThreadLocal<?> k, Object v) {
11            super(k);
12            value = v;
13        }
14    }
15
16    private static final int INITIAL_CAPACITY = 16;
17
18    private Entry[] table;
19
20    private int size = 0;
21
22    private int threshold; // Default to 0
23
24    private void setThreshold(int len) {
25        threshold = len * 2 / 3;
26    }
27
28    ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
29        table = new Entry[INITIAL_CAPACITY];
30        int i = firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1);
31        table[i] = new Entry(firstKey, firstValue);
32        size = 1;
33        setThreshold(INITIAL_CAPACITY);
34    }
35}
```

当创建一个ThreadLocalMap时，实际上内部是构建了一个Entry类型的数组，初始化大小为16，阈值threshold为数组长度的2/3，Entry类型为WeakReference，有一个弱引用指向ThreadLocal对象。


