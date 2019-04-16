package com;

/**
 * Author:Fanleilei
 * Created:2019/4/14 0014
 */
public class Count {

    //树的结点总数

    public static int countNode(Node root){

        if(root==null){
            return 0;

        }else{

            return countNode(root.left)+countNode(root.right)+1;

        }
    }

    //树的叶结点个数
    public static int countleaf(Node root){


        if(root==null){

            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;

        }else {
            return countleaf(root.left) + countleaf(root.right);
        }
    }


    //第k层的结点数
    public static int count(Node root,int k){

      //第k层的结点数等于树的子树的k-1层的结点数
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;


        }else {

            return count(root.left,k-1)+count(root.right,k-1);
        }


    }



        public static void main(String[] args) {

        Node A=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');
        Node H=new Node('H');

        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        E.right=H;
        C.left=F;
        C.right=G;

        int countNode=countNode(A);
        System.out.println("结点总数："+countNode);
        int countleaf=countleaf(A);
        System.out.println("叶子结点个数："+countleaf);
    }
}
