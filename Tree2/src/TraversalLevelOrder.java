import java.util.*;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 * 层序遍历
 *
 * 用队列
 */
public class TraversalLevelOrder {


    public static void levelOrderTrave(Node root){

       Queue<Node> queue=new LinkedList<Node>();
       if(root==null){

           return;
       }
       queue.add(root);
       while (!queue.isEmpty()) {
           //把队列中的元素出队列，同时把这个结点的左右结点入队列
           Node result=queue.poll();
           if(result!=null){       //这个地方为什么
               System.out.print(result.value);


               if(result.left!=null){
                   queue.add(result.left);
               }
               if(result.right!=null){
                   queue.add(result.right);
               }
           }


       }


    }

    public static void main(String[] args) {
        Node root=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');
        Node H=new Node('H');
        root.left=B;root.right=C;
        B.left=D;B.right=E;
        C.right=F;
        D.left=G;
        E.right=H;

        levelOrderTrave(root);
    }






}
