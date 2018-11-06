package pemrogramanDasar;

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
