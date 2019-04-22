import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 * 根据带空结点的前序遍历 还原二叉树
 *
 *
 * */


class  RV{

    Node node;
    int used;//用到的结点的个数

    public RV(Node node, int used) {
        this.node = node;
        this.used = used;
    }
}
public class CreateTree1 {


    public static RV createTree(char[] preOrder){
        if(preOrder.length==0){

            return  new RV(null,0);
        }
        /*if(preOrder[0]=='#'){

            return  new RV(null,1);
        }*/

        //先找到根结点
        Node root=new Node(preOrder[0]);
        if(root.value=='#'){
            return new RV(null,1);

        }

        //创建左子树
        //先找到左子树的前序遍历个数
        char[] leftpreOrder=new char[preOrder.length-1];
        leftpreOrder=Arrays.copyOfRange(preOrder,1,preOrder.length);//范围左闭右开
        RV leftReturnValue=createTree(leftpreOrder);

        //创建右子树
        //先找到右子树的前序遍历个数
        char[] rightpreOrder=new char[preOrder.length-1-leftReturnValue.used];
        rightpreOrder=Arrays.copyOfRange(preOrder,1+leftReturnValue.used,preOrder.length);
        RV rightReturnValue=createTree(rightpreOrder);

        //将root left right建立起关系
        root.left=leftReturnValue.node;
        root.right=rightReturnValue.node;

        return new RV(root,1+leftReturnValue.used+rightReturnValue.used);

    }

    public static void main(String[] args) {

        char[] preOrder=new char[]{'A','B','C','#','D','#','#','#','E'};

        System.out.println(createTree(preOrder).used);


    }


}
