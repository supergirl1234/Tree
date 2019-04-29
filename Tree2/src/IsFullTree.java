import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 * 判断是否是完全二叉树
 *
 * 带着空结点层序遍历，如果遇到空结点后，后面还有结点，则不是完全二叉树
 *
 *
 */
public class IsFullTree {

    public static boolean isComplete(Node root){

        //先层序遍历
        Queue<Node> queue=new LinkedList<>();
         queue.add(root);

         while(!queue.isEmpty()){
             Node node=queue.poll();

             queue.add(node.left);
             queue.add(node.right);




         }








        return true;

    }

    public static void main(String[] args) {

    }
}


