# Linked List

Linked List adalah sekumpulan elemen-elemen (boleh kosong) yang setiap elemennya terdiri atas 2 bagian, yaitu bagian data (data) dan bagian alamat (di sini terdapat prev dan next). Bagian data berisi nilai yang akan dimanipulasi, sedangkan bagian alamat berisi alamat element list sebelumnya/selanjutnya.

Jika diperhatikan pada *source code* class LinkedListNode, pendefinisian LinkedListNode bersifat rekursif. Perhatikan pada tipe dari next dan prev, yaitu LinkedListNode.

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
public class LinkedList {

    LinkedListNode head;
    LinkedListNode tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /* First set a Node named current into head
     * while current is not null, print current.data, set current = current.next
     * print end of line
     */
    void print() {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /* if LinkedList is empty, set new_node as head and tail
     * if LinkedList is not empty, set tail.next into new_node, set new_node.prev into tail, and make new_node a new tail
     */
    void push(LinkedListNode new_node) {
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
        } else {
            this.tail.set_next(new_node);
            this.tail = new_node;
        }
    }

    /* if linked list is empty, set new_node as head and tail
     * if new_node < head, make it a new head
     * if new_node > tail, make it a new tail
     * otherwise traverse to the current position, and put new_node there
     */
    void insert(LinkedListNode new_node) {
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
        } else if (new_node.data <= this.head.data) {
            this.head.set_prev(new_node);
            this.head = new_node;
        } else if (new_node.data >= this.tail.data) {
            this.tail.set_next(new_node);
            this.tail = new_node;
        } else {
            LinkedListNode position = head;
            while (position.data < new_node.data) {
                position = position.next;
            }
            LinkedListNode previous_position = position.prev;
            new_node.set_prev(previous_position);
            new_node.set_next(position);
        }
    }

    LinkedListNode find_node_by_data(int data) {
        LinkedListNode current = this.head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void delete(LinkedListNode deleted) {
        if (deleted != null && this.head != null) {
            if (this.head == this.tail && deleted == this.head) {
                this.head = null;
                this.tail = null;
            } else if (deleted == this.head) {
                LinkedListNode new_head = this.head.next;
                this.head.set_next(null);
                new_head.set_prev(null);
                this.head = new_head;
            } else if (deleted == this.tail) {
                LinkedListNode new_tail = this.tail.prev;
                this.tail.set_prev(null);
                new_tail.set_next(null);
                this.tail = new_tail;
            } else {
                LinkedListNode deleted_prev = deleted.prev;
                LinkedListNode deleted_next = deleted.next;
                deleted.set_prev(null);
                deleted.set_next(null);
                deleted_prev.set_next(deleted_next);
            }
        }
    }
}
```

### Modul3.java
```
public class Modul3 {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.print(); // should show nothing
        a.insert(new LinkedListNode(5));
        a.insert(new LinkedListNode(4));
        a.insert(new LinkedListNode(7));
        a.insert(new LinkedListNode(6));
        a.print(); // should show 4 5 6 7
        a.delete(a.head);
        a.print(); // should show 5 6 7
        a.delete(a.tail.prev);
        a.print(); // should show 5 7
        a.delete(a.tail);
        a.print(); // should show 5
        a.delete(a.head);
        a.print(); // should show nothing
    }
}
```
Untuk menambahkan fitur *searching* pada linked list, misalkan kita sudah mempunyai Scanner bernama input (tambahkan di main class) :
```
System.out.print("Masukkan data yang ingin dicari : ");
int cari = input.nextInt();
if (....(cari) == null){
    System.out.print("Data tidak ada dalam Linked List");
} else {
    System.out.print("Data ada dalam Linked List");
}
```

## Soal Tantangan
Modifikasi program Linked List yang dibuat di kelas praktikum sehingga Linked List tidak menginputkan data berupa angka, melainkan berupa **String** (tidak harus dimasukkan secara berurutan). Anda bisa mencoba untuk tipe-tipe data yang lain, bahkan tipe data *class* sekalipun.

**Keterangan :** Jika ingin menginputkan data String secara berurutan, pada method insert gunakan perbandingan berikut.
Misalkan kita mempunyai string "a" dan "b" maka :
```
"a".compareTo("b")
```
menghasilkan nilai negatif (< 0), dan perbandingan sebaliknya akan menghasilkan nilai positif (> 0). Jika kedua string sama maka nilai yang dihasilkan adalah 0.

## Daftar Pustaka
Munir, Rinaldi. 2011. *Algotirma dan Pemrograman dalam Bahasa Pascal dan C Edisi Revisi*. Bandung: Penerbit Informatika.