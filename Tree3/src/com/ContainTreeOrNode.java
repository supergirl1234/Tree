package com;

/**
 * Author:Fanleilei
 * Created:2019/4/30 0030
 */

//某颗二叉树中是否包含某个结点，是否包含某颗树
public class ContainTreeOrNode {

    //某颗二叉树中是否包含某个结点
      private static  boolean find1(Node root, char v1){

          if(root==null){

              return false;
          }
          if(root.value==v1){

              return true;
          }
          //在左子树中查找是否包含
          boolean result=find1(root.left,v1);
          if(result){
              return true;

          }
          //在右子树中查找是否包含
          result=find1(root.right,v1);
          if(result){

              return true;
          }

          return false;

      }


    //某颗二叉树中是否包含某颗树
    private static  boolean find2(Node root,Node v){
        if(root==null){

            return false;
        }
        if(root==v){

            return true;
        }
        //在左子树中查找是否包含
        boolean result=find2(root.left,v);
        if(result){
            return true;

        }
        //在右子树中查找是否包含
        result=find2(root.right,v);
        if(result){

            return true;
        }

        return false;

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
        boolean result1=find1(root,'J');
        boolean result2=find1(root,'C');
        System.out.println(result1);
        System.out.println(result2);

        boolean result3=find2(root,C);
        System.out.println(result3);

    }
}
