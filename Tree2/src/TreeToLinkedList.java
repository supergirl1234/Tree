import java.util.Stack;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 *
 * 将搜索树变成有序双向链表,相当于一个中序遍历
 *
 */
public class TreeToLinkedList {



    public static Node searchTreeToSortedList(Node root){

         prev=null;
         head=null;
        inOrderTraversalSearchTree(root);
        return head;
    }

    public static void inOrderTraversalSearchTree(Node root) {
        if(root!=null){
            inOrderTraversalSearchTree(root.left);
            buildDlist(root);
            inOrderTraversalSearchTree(root.right);

        }
    }

    public static Node prev=null;
    public static Node head=null;
    private static void buildDlist(Node node) {

        node.left=prev;
        if(prev!=null){
            prev.right=node;

        }else{
            head=node;
        }
        prev=node;
    }

    //打印链表

    public static void disply(Node head){
        Node cur=head;
        while (cur!=null){
            System.out.print(cur.value+" ");
            cur=cur.right;
        }

    }

    public static void main(String[] args) {
        Node root = new Node('6');
        Node B = new Node('4');
        Node C = new Node('8');
        Node D = new Node('2');
        Node E = new Node('5');
        Node F = new Node('1');
        Node G = new Node('3');
        Node H = new Node('7');
        Node I = new Node('9');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        C.left = H;
        C.right = I;
        D.left = F;
        D.right = G;

        Node node=searchTreeToSortedList(root);
        disply(node);

    }

}
