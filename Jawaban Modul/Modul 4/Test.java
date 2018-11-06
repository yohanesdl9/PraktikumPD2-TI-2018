package pemrogramanDasar;

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
