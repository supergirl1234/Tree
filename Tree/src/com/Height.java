package com;



/**
 * Author:Fanleilei
 * Created:2019/4/13 0013
 */
public class Height {


    public static  int height(Node root){


        if(root==null){

            return 0;

        }else if(root.left==null&&root.right==null){
            //可选
            return  1;

        }else{
            int leftHeight=height(root.left);

            int rightHeight=height(root.right);

            return (leftHeight>=rightHeight ? leftHeight : rightHeight)+1;

        }
    }
}
