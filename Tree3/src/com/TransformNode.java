package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:Fanleilei
 * Created:2019/4/30 0030
 */
public class TransformNode {
    //用带空结点的前序遍历建立二叉树

    //为了实现一个函数返回两个值得效果，把两个不同的返回值打包到一个类里
   private static class CreateTreeRV{

        //创建好的二叉树的根节点
        private Node returnRoot;
        //使用的个数
        private int used;

        private CreateTreeRV(Node returnRoot, int used) {
            this.returnRoot = returnRoot;
            this.used = used;
        }
    }

    private static CreateTreeRV createTree(char[] array){

        if(array.length==0){
            return new CreateTreeRV(null,0);
        }
        char rootValue=array[0];
        if(rootValue=='#'){
            return new CreateTreeRV(null,1);

        }
        //根节点
        Node root=new Node(rootValue);
        //创建左子树，利用递归
        char[] leftPreOrder=new char[array.length-1];
        leftPreOrder=Arrays.copyOfRange(array,1,array.length);
        CreateTreeRV leftReturn=createTree(leftPreOrder);

        //右子树，利用递归
        //右子树的长度= length - 根的长度 - 左子树的长度
        char[] rightPreOrder = new char[array.length - 1 - leftReturn.used];
        rightPreOrder = Arrays.copyOfRange(array, 1 + leftReturn.used, array.length);
        CreateTreeRV rightReturn = createTree(rightPreOrder);


        //绑定左右子树
        root.left = leftReturn.returnRoot;
        root.right = rightReturn.returnRoot;
        // 使用的个数是
        return new CreateTreeRV(
                root,
                1 + leftReturn.used + rightReturn.used
        );

    }

    //找出两个节点的最近的公共祖先
    private static Node lowCommomAncestor(Node root,Node v1,Node v2){

        if(root==v1||root==v2){
            return root;

        }
       boolean v1LeftResult=find(root.left,v1);
        boolean v2LeftResult=find(root.left,v2);



        if(v1LeftResult&&v2LeftResult){
            return lowCommomAncestor(root.left,v1,v2);

        }else if(!v1LeftResult&&!v2LeftResult){
            return lowCommomAncestor(root.right,v1,v2);

        }

        return root;
    }

    //二叉树中是否包含某个结点
    private static boolean find(Node root,Node k){

        if(root==null){

            return false;
        }
        if(root==k){
            return true;
        }
        boolean result=find(root.left,k);
        if(result){

            return true;
        }
        result=find(root.right,k);
        if(result){

            return true;
        }

        return false;

    }
    //判断二叉树是否是完全二叉树

    public static boolean isCompleted(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node==null){
                //遇到空了，下一步去判断队列中剩余的结点，是否是全是空
                break;

            }
                queue.add(node.left);
                queue.add(node.right);


        }

        //来判断队列中剩余的结点是否全是空
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node!=null){
                return  false;
            }

        }
        return  true;

    }

    //将二叉树转换为字符串(A(B(D()(H)))(C(E)(F)))  如果左孩子为空，（）不能省略，如果右孩子为空，（）能省略
    static  StringBuilder str=new StringBuilder();
    private static String treeToString(Node root){
         //StringBuilder str=new StringBuilder();//在这个位置不合适，不能每次都新创建一个str，要不然每次都相遇于是重头开始的
         if(root!=null) {
             str.append('(');
             str.append(root.value);
             if (root.left == null&& root.right != null) {
                 str.append("()");
             } else {
                 treeToString(root.left);
             }
             treeToString(root.right);
             str.append(')');
         }
         return str.toString();

    }


    public static void main(String[] args) {

        char[] array=new char[]{'A','B','D','#','C','E','F','G'};

        CreateTreeRV treeRV=createTree(array);
        System.out.println(treeRV.used);
        TraversalTree.preOrde2(treeRV.returnRoot);

        Node root=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');

        root.left=B;root.right=C;
        B.left=D;
        C.left=E;C.right=F;
        D.right=G;

        Node result1=lowCommomAncestor(root,E,B);
        Node result2=lowCommomAncestor(root,B,D);
        Node result3=lowCommomAncestor(root,E,F);


        if(result1!=null){ System.out.println(result1.value);}
        if(result2!=null){ System.out.println(result2.value);}
        if(result3!=null){System.out.println(result3.value);}



        boolean result=isCompleted(root);
        System.out.println("是否是完全二叉树："+result);
        System.out.println(B.right);

        String str=treeToString(root);
        System.out.println(str);


    }
}
