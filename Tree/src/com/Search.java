package com;

/**
 * Author:Fanleilei
 * Created:2019/4/13 0013
 */
public class Search {


    //查找树中是否含有某个数
    public static Node find(Node root,char v){

       /* Node node;
        if(root==null){
            return  null;

        }else if(root.vaule==v){
            return root;
        }else{

            node=find(root.left,v);

        }

        if(node==null){
            node=find(root.right,v);
        }

        return  node;*/

       if(root==null){
           return  null;


       }
        if(root.vaule==v){
            return root;
        }

        Node node=find(root.left,v);
       if (node!=null){

           return node;
       }

         node=find(root.right,v);
        if (node!=null){

            return node;
        }

        return  null;
    }

    //找到包含v的结点，返回结点引用


    public static Node search(Node root,Node v){

        if(root==null){
            return null;
        }
        if(root==v){
            return root;
        }

       Node node=search(root.left,v);
        if(node!=null){

            return  node;
        }
        node=search(root.right,v);
        if(node!=null){

            return  node;
        }

        return  null;

    }


}
