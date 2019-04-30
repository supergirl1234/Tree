package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author:Fanleilei
 * Created:2019/4/30 0030
 */
public class TraversalTree {

    //递归遍历

    //前序遍历
    private static void preOrd(Node root){

        if(root!=null){
            System.out.print(root.value);
            preOrd(root.left);
            preOrd(root.right);

        }
    }
    //中序遍历
    private static void inOrd(Node root){

        if(root!=null){

            inOrd(root.left);
            System.out.print(root.value);
            inOrd(root.right);

        }
    }

    //后序遍历
    private static void posOrd(Node root){
        if(root!=null){
            posOrd(root.left);
            posOrd(root.right);
            System.out.print(root.value);

        }

    }


    //非递归遍历
    //前序遍历
    public static void preOrde2(Node root){
        /*Stack<Node> stack=new Stack<>();
        while(root!=null){
            stack.push(root);
            System.out.print(root.value);
            root=root.left;

        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            while (node.right != null) {
                stack.push(node.right);
                System.out.print(node.right.value);
                node.right=node.right.left;

            }
        }*/


        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                System.out.print(cur.value);//在第一次进栈的时候输出
                cur=cur.left;  //先进左子树
            }
            Node node=stack.pop();
            cur=node.right;  //再进右子树

        }

    }

    //中序遍历
    private static void inOrde2(Node root){

        /*Stack<Node> stack=new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;

        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value);
            while (node.right != null) {
                stack.push(node.right);
                node.right=node.right.left;

            }
        }*/

        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;  //先进左子树
            }
            Node node=stack.pop();
            System.out.print(node.value);//在第二次碰见出栈的时候输出
            cur=node.right;//再进右子树

        }


    }
    //后序遍历
    private static void posOrde2(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        Node last=null;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            Node node=stack.peek();
            if(node.right==null){
                System.out.print(node.value);
                stack.pop();
                last=node;

            }else if(node.right==last){
                System.out.print(node.value);
                stack.pop();
                last=node;

            }else{
                cur=node.right;
            }

        }

    }


    //层序遍历
    private static void CengOrder(Node root){

        Queue<Node> queue=new LinkedList<>();

            queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node!=null) {
                System.out.print(node.value);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
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
        C.left=F;C.right=G;
        D.left=H;
        System.out.println("递归遍历");
        preOrd(root);
        System.out.println();
        inOrd(root);
        System.out.println();
        posOrd(root);
        System.out.println();
        System.out.println("非递归遍历");

        preOrde2(root);
        System.out.println();
        inOrde2(root);
        System.out.println();
        posOrd(root);


        System.out.println();
        System.out.println("层序遍历");
        CengOrder(root);

    }

}
