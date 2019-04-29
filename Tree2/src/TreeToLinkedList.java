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


    public static NodeLinkedList treeToNode(Node root) {
return null;
    }

    //打印链表

    public static void disply(NodeLinkedList head){
        NodeLinkedList cur=head;
        while (cur!=null){
            System.out.println(cur.vaule+" ");
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

        NodeLinkedList node=treeToNode(root);
        disply(node);

    }

}
