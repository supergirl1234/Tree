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

        if(root==null){
            return  true;

        }
        //先层序遍历
        Queue<Node> queue=new LinkedList<>();
         queue.add(root);

         while(true){
             Node node=queue.poll();

             if(node==null){
                 //遇到空了，下一步去判断队列中剩余的结点，是否是全是空
                 break;
             }
             queue.add(node.left);
             queue.add(node.right);
         }

         //判断是否所有的结点都是非空
        while(!queue.isEmpty()){
             Node node=queue.poll();
             if(node!=null){
                return false;
             }

        }

        return true;

    }

    public static void main(String[] args) {

    }
}


