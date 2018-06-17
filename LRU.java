class LRUCache{
    private Node head = null;
    private Node tail = null;
    private HashMap<Integer, Node> map;
    private int num;
    private int cap;
    public LRUCache(int capacity){
        this.cap = capacity;
        this.map = new HashMap<Integer,Node>(capacity);
        this.num = 0;
        this.head = new Node(-1,0);
        this.tail = new Node(-1,0);
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.prev = this.head;
        this.tail.next = null;
    }

    public int get(int key) {
        Node ret = map.get(key);

        if (ret == null){
            return -1;
        }
        else {
            ret.prev.next = ret.next;
            ret.next.prev = ret.prev;
            ret.next = head.next;
            ret.prev = head;
            ret.next.prev = ret;
            head.next = ret;
            return ret.value;
        }
    }

    public void put(int key, int value) {
        int val = this.get(key);
        if (val != -1){
            map.get(key).value = value;
            return;
        }
        if (this.num + 1 > this.cap){
            map.remove(this.tail.prev.key);
            this.tail.prev = this.tail.prev.prev;
            this.tail.prev.next = this.tail;
        }
        this.num = Math.min(this.cap,this.num + 1);
        Node nnode = new Node(key,value);
        nnode.next = head.next;
        nnode.prev = head;
        nnode.next.prev = nnode;
        head.next = nnode;
        map.put(key,nnode);
    }
}
class Node{
    Node prev;
    Node next;
    int key;
    int value;
    public Node(int k,int v){
        key = k;
        value = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
