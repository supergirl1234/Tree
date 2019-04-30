package com;

/**
 * Author:Fanleilei
 * Created:2019/4/30 0030
 */
public class Count {

    //一颗二叉树中有多少个叶子节点

    private static int leafCount(Node root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return leafCount(root.left) + leafCount(root.right);


    }

    //一颗二叉树的高度
    private static int height(Node root) {
        if (root == null) {
            return 0;

        }
        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.left) + 1;
        return (leftHeight > rightHeight) ? leftHeight : rightHeight;

    }


    //二叉树结点的个数
    public static int count = 0;

    //最普通的方法就是遍历
    private static void nodeCount1(Node root){
        if(root!=null) {
        count++;
        nodeCount1(root.left);
        nodeCount1(root.right);

      }

    }
    private static int nodeCount2(Node root){



      //将其分解为分别求其左子树的结点数和右子树的结点数
        if(root==null){

            return 0;
        }else{

            return nodeCount2(root.left)+nodeCount2(root.right)+1;
        }


    }


    //第k层结点数
    private static int kLevelCount(Node root,int k){

        if(root==null){

            return 0;
        }
        if(k==1){
            return  1;
        }

       return kLevelCount(root.left,k-1)+kLevelCount(root.right,k-1);//还是分为左右子数

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
        C.left=F;C.right=G;
        D.left=H;

        int result1=leafCount(root);
        System.out.println("二叉树的叶子结点数："+result1);

        int result2=height(root);
        System.out.println("二叉树的高度："+result2);

        int result3=nodeCount2(root);
        System.out.println("二叉树的结点总数为："+result3);
        nodeCount1(root);
        System.out.println("二叉树的结点总数为："+count);

        int result4=kLevelCount(root,3);
        System.out.println("二叉树中第三层的结点数:"+result4);
    }
}
