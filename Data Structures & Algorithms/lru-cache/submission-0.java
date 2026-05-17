class Node{
   int key;
   int value;
   Node prev;
   Node next;
   Node (int key , int value)
   {
    this.key=key;
    this.value = value;
   }

}


class LRUCache {

    private final Map<Integer,Node> map;
    private final int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node (0,0);
        head.next = tail;
        tail.prev= head;
    }

    public void remove( Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtTail(Node node)
    {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;

    }
    
    public int get(int key) {

            if(!map.containsKey(key))
            {return -1;}
            else{
                Node node = map.get(key);
                remove(node);
                insertAtTail(node);
                return node.value;
            }
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key))
        {
            remove(map.get(key));
            map.remove(key);
        }
        if(map.size() == capacity)
        {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key,value);
        insertAtTail(newNode);
        map.put(key, newNode);
        
    }
}
