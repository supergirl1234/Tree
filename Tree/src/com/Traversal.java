package com;

/**
 * Author:Fanleilei
 * Created:2019/4/14 0014
 *
 * 前序、中序、后序遍历
 */
public class Traversal {


    //前序遍历

    public static  void preTraversal(Node root){


        if(root!=null) {
            System.out.print(root.vaule+" ");

            preTraversal(root.left);


            preTraversal(root.right);
        }
    }


    //中序遍历
    public static  void inTraversal(Node root){


        if(root!=null) {
            inTraversal(root.left);
            System.out.print(root.vaule+" ");

            inTraversal(root.right);
        }
    }

    //后序遍历
    public static  void postTraversal(Node root){


        if(root!=null) {
            postTraversal(root.left);
            System.out.print(root.vaule+" ");

            postTraversal(root.right);
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

        preTraversal(A);
        inTraversal(A);
        postTraversal(A);
    }
}
