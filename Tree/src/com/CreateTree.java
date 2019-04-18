package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/18 0018
 *
 *
 * 不能用普通的前序遍历创建二叉树
 * 用带空间点的前序遍历创建二叉树
 *
 */
public class CreateTree {

    class RV{

        Node node;
        int used;

        public RV(Node node, int used) {
            this.node = node;
            this.used = used;
        }
    }



    //利用带空结点的前序构建二叉树
     RV createTree(char[] preOrder){

        if(preOrder.length==0){
            return new RV(null,0);
        }else if(preOrder[0]=='#'){

            return  new RV(null,1);
        }

        //创建根节点
       Node root=new Node(preOrder[0]);

       //用剩下的结点，创建左子树
        char[] leftNode=new char[preOrder.length-1];
        leftNode=Arrays.copyOfRange(preOrder,1,preOrder.length);
        RV leftReturn=createTree(leftNode);


        //用剩下的结点创建右子树
        char[] rightNode=new char[preOrder.length-1-leftReturn.used];
        rightNode =Arrays.copyOfRange(leftNode,leftReturn.used,leftNode.length);
        RV rightReturn=createTree(rightNode);


        root.left=leftReturn.node;
        root.right=rightReturn.node;

        return new RV( root, 1+leftReturn.used+rightReturn.used);

    }

    public static void main(String[] args) {
        CreateTree Tree=new CreateTree();

        char[] Order=new char[]{'A','B','C','#','D','#','#','#','E'};
        RV result=Tree.createTree(Order);
        System.out.println(result.used);
    }
}
