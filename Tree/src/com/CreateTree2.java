package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/18 0018
 *
 *
 * 还没写完
 * 用前序和中序遍历创建二叉树
 * 用中序和后序遍历创建二叉树
 */
public class CreateTree2 {

    //找到某个结点的位置
    static int Find(char[] array,char v){

        for(int i=0;i<array.length;i++){
            if(array[i]==v){

                return i;
            }

        }
       return -1;
    }


   static Node buildTree(char[] inorder,char[] postorder){

        if(inorder.length==0){
            return null;

        }

        //在后序遍历中找到根节点
        Node root=new Node(postorder[postorder.length-1]);
        //在中序中找到根节点的位置
        int leftSize=Find(inorder,root.vaule);

        //在中序遍历中找到左子树
       char[] leftInorder=Arrays.copyOfRange(inorder,0,leftSize);
       //在后序遍历中找到左子树
       char[] leftPostorder=Arrays.copyOfRange(inorder,0,leftSize);
       //再用中序和后序遍历创建左子树的二叉树
       buildTree(leftInorder,leftPostorder);


       //在中序遍历中找到右子树
       char[] rightInorder=Arrays.copyOfRange(inorder,leftSize+1,inorder.length);
       //在后序遍历中找到右子树
       char[] rightPostorder=Arrays.copyOfRange(inorder,leftSize,postorder.length-1);
       //再用中序和后序遍历创建右子树的二叉树
       buildTree(rightInorder,rightPostorder);


      return root;
    }



    public static void main(String[] args) {

    }
}


