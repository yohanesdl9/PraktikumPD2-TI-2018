# Binary Tree
## Apakah itu Binary Tree?
Binary tree adalah struktur data pohon dimana setiap simpul memiliki paling banyak dua anak, yang secara khusus dinamakan kiri (left) dan kanan (right).

## Traversing dalam Binary Tree
Untuk mengunjungi simpul-simpul di dalam Binary Tree, dikenal 3 teknik :
- **Infix** : left-root-right (simpul akar dikunjungi di antara simpul anak-anaknya).
- **Prefix** : root-left-right (simpul akar dikunjungi sebelum simpul anak-anaknya).
- **Postfix** : left-right-root (simpul akar dikunjungi setelah simpul anak-anaknya).

## Binary Tree Simulation
- http://www.cs.armstrong.edu/liang/animation/web/BST.html

## Source Code
### BinaryTreeNode.java
```
public class BinaryTreeNode{
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;
    int data;

    /* Set data to new_data
     * set parent, left, and right into null
     */
    BinaryTreeNode(int new_data){
        this.data = new_data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /* set other as parent of this node
     * if other is not null, and other's data is bigger than this data then set this as other's left
     * if other is not null, and other's data is lesser than this data then set this as other's right
     */
    void set_parent(BinaryTreeNode other){
        this.parent = other;
        if(other != null){
            if(other.data > this.data){
                other.left = this;
            }else{
                other.right = this;
            }
        }
    }

    /* set other as left of this node
     * if other is not null set other's parent to this node
     */
    void set_left(BinaryTreeNode other){
        this.left = other;
        if(other != null){
            other.parent = this;
        }
    }

    /* set other as right of this node
     * if other is not null set other's parent to this node
     */
    void set_right(BinaryTreeNode other){
        this.right = other;
        if(other != null){
            other.parent = this;
        }
    }

    /* if this node's parent is not null and parent's left is this, return true
     * otherwise return false
     */
    boolean is_left(){
        if(this.parent != null && parent.left == this){
            return true;
        }else{
            return false;
        }
    }

    /* if this node's parent is not null and parent's right is this, return true
     * otherwise return false
     */
    boolean is_right(){
        if(this.parent != null && parent.right == this){
            return true;
        }else{
            return false;
        }
    }

    /* if this left is not null and this right is not null, return true
     */
    boolean has_right_and_left(){
        if(this.left != null && this.right != null){
            return true;
        }else{
            return false;
        }
    }

    /* if this left is not null but this right is null, return true
     */
    boolean only_has_left(){
        if(this.left != null && this.right == null){
            return true;
        }else{
            return false;
        }
    }

    /* if this right is not null but this left is null, return true
     */
    boolean only_has_right(){
        if(this.right != null && this.left == null){
            return true;
        }else{
            return false;
        }
    }

    boolean has_no_child(){
        if(this.right == null && this.left == null){
            return true;
        }else{
            return false;
        }
    }

    /* if this node is it's parent left child, set parent's left = null and this parent = null
     * if this node is it's parent right child, set parent's right = null and this parent = null
     */
    void unset_parent(){
        if(this.is_left()){
            this.parent.left = null;
            this.parent = null;
        }else if(this.is_right()){
            this.parent.right = null;
            this.parent = null;
        }
    }

    /* set child as left of this node
     * while child's left is not null, set child into child's left
     * return child
     */
    BinaryTreeNode most_left_child(){
        BinaryTreeNode child = this.left;
        while(child.left != null){
            child = child.left;
        }
        return child;
    }

    /* set child as right of this node
     * while child's right is not null, set child into child's right
     * return child
     */
    BinaryTreeNode most_right_child(){
        BinaryTreeNode child = this.right;
        while(child.right != null){
            child = child.right;
        }
        return child;
    }

    /* recursively print node
     * print spaces + label + node's data
     * if node's left is not null, call left's print method with additional space and "LEFT" label
     * if node's right is not null, call right's print method with additional space and "RIGHT" label
     */
    void print(String spaces, String label){
        System.out.println(spaces + label + " " + this.data);
        if(this.left != null){
            this.left.print(spaces + " ", "LEFT");
        }
        if(this.right != null){
            this.right.print(spaces + " ", "RIGHT");
        }
    }

    // Alias for print("", "NODE");
    void print(){
        this.print("", "NODE");
    }

    /* recursively print node with infix mode
     * print "("
     * if node's left is not null, run left's infix method, otherwise print "null"
     * print space + this node's data + space
     * if node's right is not null, run right's infix method, otherwise print "null"
     * print ")"
     */
    void infix(){
        System.out.print("(");
        if(this.left != null){
            left.infix();
        }else{
            System.out.print("null");
        }
        System.out.print(" " + this.data + " ");
        if(this.right != null){
            right.infix();
        }else{
            System.out.print("null");
        }
        System.out.print(")");
    }

    /* recursively print node with prefix mode
     * print this node's data + "("
     * if node's left is not null, run left's prefix method, otherwise print "null"
     * print space
     * if node's right is not null, run right's prefix method, otherwise print "null"
     * print ")"
     */
    void prefix(){
        System.out.print(this.data + "(");
        if(this.left != null){
            left.prefix();
        }else{
            System.out.print("null");
        }
        System.out.print(" ");
        if(this.right != null){
            right.prefix();
        }else{
            System.out.print("null");
        }
        System.out.print(")");
    }

    /* recursively print node with postfix mode
     * print "("
     * if node's left is not null, run left's postfix method, otherwise print "null"
     * print space 
     * if node's right is not null, run right's postfix method, otherwise print "null"
     * print ")" + this node's data
     */
    void postfix(){
        System.out.print("(");
        if(this.left != null){
            left.postfix();
        }else{
            System.out.print("null");
        }
        System.out.print(" ");
        if(this.right != null){
            right.postfix();
        }else{
            System.out.print("null");
        }
        System.out.print(")" + this.data);
    }
}
```

### BinaryTree.java
```
public class BinaryTree{
    BinaryTreeNode root;
    
    public BinaryTree(){
        this.root = null;
    }

    /* call method print of root if root is not null */
    void print(){
        if(this.root != null){
            this.root.print();
        }
    }
    /* call method prefix of root if root is not null, print new line */
    void prefix(){
        if(this.root != null){
            this.root.prefix();
        }
        System.out.println();
    }
    /* call method infix of root if root is not null, print new line */
    void infix(){
        if(this.root != null){
            this.root.infix();
        }
        System.out.println();
    }

    /* call method postfix of root if root is not null, print new line */
    void postfix(){
        if(this.root != null){
            this.root.postfix();
        }
        System.out.println();
    }

    /* if root is null, set new_node as root
     * otherwise, set current to root
     * while current is not null
     *      if new_node's data bigger than current's data and current has right, then set current = current's right
     *      if new node's data bigger than current's data and current doesn't have right, then put new_node as current's right, break from loop
     *      if new_node's data smaller than current's data and current has left, then set current = current's left
     *      if new_node's data smaller than current's data and current doesn't have left, then put new_node as current's left, break from loop
     */
    void push(BinaryTreeNode new_node){
        if(this.root == null){
            this.root = new_node;
        } else {
            BinaryTreeNode current = this.root;
            while(current != null){
                if(new_node.data > current.data){
                    if(current.right == null){
                        current.set_right(new_node);
                        break;
                    } else {
                        current = current.right;
                    }
                }else{
                    if(current.left == null){
                        current.set_left(new_node);
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }

    /* only able to delete if root is not null
     * if deleted doesn't have any child, then unset_parent
     * if deleted only has one child, then let the child replace deleted
     * if deleted has two child, then let deleted's left's most right to replace deleted
     */
    void delete(BinaryTreeNode deleted){
        if(this.root != null){
            if(deleted.has_no_child()){
                if(deleted == this.root){
                    this.root = null;
                }else{
                    deleted.unset_parent();
                }
            }else if(deleted.only_has_left() || deleted.only_has_right()){
                BinaryTreeNode replacement = null;
                if(deleted.only_has_left()){
                    replacement = deleted.left;
                }else{
                    replacement = deleted.right;
                }
                if(deleted == this.root){
                    this.root = replacement;
                    this.root.unset_parent();
                }else if(deleted.is_left()){
                    deleted.parent.set_left(replacement);
                    deleted.unset_parent();
                }else if(deleted.is_right()){
                    deleted.parent.set_right(replacement);
                    deleted.unset_parent();
                }
            }else{
                BinaryTreeNode replacement = deleted.left;
                if(replacement.right != null){
                    replacement = replacement.most_right_child();
                }
                BinaryTreeNode parent_of_replacement = replacement.parent;
                if(replacement.only_has_right()){
                    parent_of_replacement.set_left(replacement.right);
                }
                replacement.unset_parent();
                replacement.set_left(deleted.left);
                replacement.set_right(deleted.right);
                if(deleted == this.root){
                    this.root = replacement;
                }else if(deleted.is_left()){
                    deleted.parent.set_left(replacement);
                }else if(deleted.is_right()){
                    deleted.parent.set_right(replacement);
                }
            }
        }
    }

    BinaryTreeNode traverse(int data) {
        BinaryTreeNode current = this.root;
        while (current != null) {
            if (current.data == data) {
                return current;
            } else {
                if (current.data < data) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
        }
        return null;
    }
}
```