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