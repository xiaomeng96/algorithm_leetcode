package _146;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * 哈希表+双链表
 * @author xm
 *
 */

public class LRUCache {
	//双链表缓存
	private DLinkedList cache;
	//构建哈希映射
	private HashMap<Integer, Node> map;
	//最大容量
	private int cap;
	
    public LRUCache(int capacity) {//初始化
    	cache = new DLinkedList();
    	map = new HashMap<Integer, Node>();
    	cap = capacity;
    }
    
    public int get(int key) {

    	//map中不存在key时，返回-1
    	if(!map.containsKey(key)) {
    		return -1;
    	}
    	//存在时，获取该键对应的值
    	int val = map.get(key).val;
    	//并将该节点放在双链表头结点后面
    	put(key, val);	
    	return val;
    }
    
    public void put(int key, int value) {
    	//新的节点
    	Node x = new Node(key, value);
    	//如果map中存在该key
    	if(map.containsKey(key)) {
    		//删除双链表中旧的节点
    		cache.remove(map.get(key));
    		//将新的节点添加到链表头部
    		cache.addFirst(x);
    		//更新map
    		map.put(key, x);
    		
    	}else {//如果map中不存在该key
    		//判断链表容量是否已满
    		if(cache.getSize() == cap) {//容量已满，删除最后一个节点
    			Node last = cache.removeLast();
    			map.remove(last.key);//map中也要删掉
    		}
    		cache.addFirst(x);
    		map.put(key, x);  		
    	}

    }
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // 返回  1
		cache.put(3, 3);    // 该操作会使得关键字 2 作废
		System.out.println(cache.get(2));         // 返回 -1 (未找到)
		cache.put(1, 4);    // 该操作会使得关键字 1 的值替换为新值
		System.out.println(cache.get(1));         // 返回 4 
		System.out.println(cache.get(3));         // 返回  3

	}

}
