package com;

/**
 * Author:Fanleilei
 * Created:2019/4/18 0018
 */
public class Search2 {


    class Node{


        char value;
        Node left;
        Node right;

    }


    public static Node find(Node root,char v){


        if(root==null){

            return null;
        }
        if(root.value==v){

            return  root;
        }
        Node node=find(root.left,v);

        if(node!=null){

            return node;

        }

        node=find(root.right,v);

        if(node!=null){

            return node;

        }

        return  null;
    }
}
