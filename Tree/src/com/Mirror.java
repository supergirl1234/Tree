package com;

/**
 * Author:Fanleilei
 * Created:2019/4/13 0013
 *
 * 判断一个二叉树是否是镜像对称
 */
public class Mirror {

    public static boolean isMirror(Node p,Node q){

        if(p==null&&q==null){
            return true;

        }
        if(p==null||q==null){

            return  false;
        }

        return  p.vaule==q.vaule
                && isMirror(p.left,q.left)
                && isMirror(p.right,q.right);


    }

    public static boolean isMirror(Node root){

        if(root==null){
            return true;

        }

        return isMirror(root.left,root.right);



    }
}