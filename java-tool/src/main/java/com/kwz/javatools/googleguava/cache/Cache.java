package javatools.googleguava.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description
 * Date 2021/1/27 20:13
 * //
 * 实现一个简易的缓存
 * <p>
 * 缓存的置换机制为【最近最少使用】
 * 支持读取操作get，要求时间复杂度为O(1)
 * 支持写入操作put，当缓存达到容量上限时，根据置换机制置换数据，要求时间复杂度为O(1)
 * 支持的数据类型简化为整型数值
 * java集合类型只能使用ArrayList\HashMap，可自己实现其他数据结构
 * 缓存的操作要求线程安全
 * 例子：
 * <p>
 * Cache cache = new Cache( 2  );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 值 2 失效，值 3 写入缓存
 * cache.get(2);       // 返回 null (未找到)
 * cache.put(4,4);    // 值 1 失效
 * cache.get(1);       // 返回 null (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class Cache {

    private Integer maxSize;
    private Integer size;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final ArrayList<Integer> list;
    private final HashMap<Integer, Integer> cacheMap;
    private Node headNode = new Node();
    private Node tailNode = new Node();

    public Cache(int maxSize) {
        this.maxSize = maxSize;
        cacheMap = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    private void put(Integer key, Integer value) {
        writeLock.lock();
        try {
            //将重复的删除，保证最新的放在最后
            if (list.contains(key)) {
                list.remove(key);
            } else {
                //达到最大容量，将最老的删除
                if (list.size() == maxSize) {
                    Integer oldKey = list.remove(0);
                    cacheMap.remove(oldKey);
                }
            }
            list.add(key);
            cacheMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    private Integer get(Integer key) {
        readLock.lock();
        try {
            if (!list.contains(key)) {
                return null;
            }
            //老的移除，新的放在最后面
            list.remove(key);
            list.add(key);
            return cacheMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    private void add(Node node) {
        Node oldNode = headNode.next;
        headNode.next = node;
        node.pre = headNode;
        node.next = oldNode;
        headNode.pre = node;
    }

    private void delete(Node node) {

    }

    public static void main(String[] args) {
        Cache cache = new Cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class Node {
    public Integer key;
    public Integer value;
    public Node pre;
    public Node next;

    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
