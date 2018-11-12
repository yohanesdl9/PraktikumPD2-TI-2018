# Stack & Queue
## Stack
Menerapkan konsep LIFO (*Last In First Out*). Data yang terakhir dimasukkan (*push*) akan dikeluarkan (*pop*) pertama.

## Queue
Menerapkan konsep FIFO (*First In First Out*). Data yang pertama dimasukkan (*push*) akan dikeluarkan (*pop*) pertama juga.

## Source Code
### LinkedListNode.java
```
public class LinkedListNode{
     LinkedListNode next;
     LinkedListNode prev;
     int data;

    /* Constructor
     * set this.data into new_data
     * set this.prev into null
     * set this.next into null
     */
     LinkedListNode(int new_data){
        this.data = new_data;
        this.prev = null;
        this.next = null;
    }

    /* set this.prev into other
     * if other is not null, set other.next into this
     */
     void set_prev(LinkedListNode other){
        this.prev = other;
        if(other != null){
            other.next = this;
        }
    }

    /* set this.next into other
     * if other is not null, set other.prev into this
     */
     void set_next(LinkedListNode other){
        this.next = other;
        if(other != null){
            other.prev = this;
        }
    }
}
```
### LinkedList.java
```
public class LinkedList{
    LinkedListNode head;
    LinkedListNode tail;

    LinkedList(){
        this.head = null;
        this.tail = null;
    }

    /* First set a Node named current into head
     * while current is not null, print current.data, set current = current.next
     * print end of line
     */
    void print(){
        LinkedListNode current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /* if LinkedList is empty, set new_node as head and tail
     * if LinkedList is not empty, set tail.next into new_node, set new_node.prev into tail, and make new_node a new tail
     */
    void push(LinkedListNode new_node){
        if(this.head == null){
            this.head = new_node;
            this.tail = new_node;
        }else{
            this.tail.set_next(new_node);
            this.tail = new_node;
        }
    }

    /* declare a node named taken
     * if LinkedList is empty, set taken into null
     * if linkedList consists only one node, set taken = head, set both head and tail into null
     * if linkedList consists of two or more nodes, set taken = head, set head.next into new head, cut off all the link between taken and head
     * return taken
     */
    LinkedListNode qpop(){
        LinkedListNode taken;
        if(this.head == null){
            taken = null;
        }else if(this.head == this.tail){
            taken = this.head;
            this.head = null;
            this.tail = null;
        }else{
            taken = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            taken.next = null;
        }
        return taken;
    }

    /* declare a node named taken
     * if LinkedList is empty, set taken into null
     * if linkedList consists only one node, set taken = tail, set both head and tail into null
     * if linkedList consists of two or more nodes, set taken = tail, set tail.prev into new tail, cut off all the link between taken and tail
     * return taken
     */
    LinkedListNode spop(){
        LinkedListNode taken;
        if(this.head == null){
            taken = null;
        }else if(this.head == this.tail){
            taken = this.head;
            this.head = null;
            this.tail = null;
        }else{
            taken = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            taken.prev = null;
        }
        return taken;
    }
}
```

### Test.java
```
public class Test{
    public static void main(String Args[]){
        // == Test case for linked list, queue and stack ==
        LinkedList l = new LinkedList();
        l.print(); // should show null
        System.out.println(l.qpop()); // should show null
        System.out.println(l.spop()); // should show null
        l.push(new LinkedListNode(5));
        l.push(new LinkedListNode(4));
        l.print(); // should show "5 4"
        System.out.println(l.spop().data); // should show "4"
        l.push(new LinkedListNode(4));
        System.out.println(l.qpop().data); // should show "5"
        l.print(); // should show "4"
        l.qpop(); // now the linked list should be empty
    }

}
```