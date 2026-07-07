class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    Map<Integer, Node> store;
    int size;

    public LRUCache(int capacity) {
        size = capacity;
        head.next = tail;
        tail.prev = head;
        store = new HashMap<>();
    }
    
    public void addNodeAtHead(Node newNode) {
        Node tempNode = head.next;
        
        head.next = newNode;
        tempNode.prev = newNode;
        
        newNode.prev = head;
        newNode.next = tempNode;
    }

    public void removeNode(Node deleteNode) {

        Node prev = deleteNode.prev;
        Node next = deleteNode.next;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        
        if(store.containsKey(key)) {
            Node existing = store.get(key);
            removeNode(existing);

            addNodeAtHead(existing);
            return existing.val;
        } else return -1;
        
    }
    
    public void put(int key, int value) {

        if(store.containsKey(key)) {
            Node existing = store.get(key);
            removeNode(existing);
            store.remove(key);
            
            Node newNode = new Node(key, value);
            addNodeAtHead(newNode); 
            store.put(key, newNode);
            return;
        }

        if(store.size() == size) {
            Node lru = tail.prev;
            removeNode(lru);
            store.remove(lru.key);
            
        }

        Node newNode = new Node(key, value);
        addNodeAtHead(newNode);
        store.put(key, newNode);
    }
}
