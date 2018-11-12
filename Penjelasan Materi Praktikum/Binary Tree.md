# Binary Tree

## Source Code
### BinaryTreeNode.java

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
}
```