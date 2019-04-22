/**
 * Author:Fanleilei
 * Created:2019/4/21 0021
 *
 * 在二叉树中查找是否含有某个值
 * 在二叉树中查找是否含有某个子树
 * 如果存在就输出
 */
public class SearchNode {
//在二叉树中查找是否含有某个值
    public static Node isOfValue(Node root, char v){


        //这个是要有的，首先要判断树是否为空
        if(root==null){
            return null;

        }
        //现在根中查找

        if(root.value==v){

            return  root;
        }
        //再在左子树中查找
        Node node= isOfValue(root.left,v);
        if(node!=null){

            return  node;
        }

        //再在右子树种查找
        node= isOfValue(root.right,v);
        if(node!=null){

            return  node;
        }


        return null;


    }
    // 在二叉树中查找是否含有某个子树
    public static Node isOfTree(Node root, Node v){

        if(root==null){
            return null;

        }
        //现在根中查找

        if(root==v){

            return  root;
        }
        //再在左子树中查找
        Node node=isOfTree(root.left,v);
        if(node!=null){

            return  node;
        }

        //再在右子树种查找
        node= isOfTree(root.right,v);
        if(node!=null){

            return  node;
        }


        return null;


    }

    //前序遍历二叉树

    public static void preOrder(Node root){

        if(root!=null){

            System.out.print(root.value);
            //遍历右子树
            preOrder(root.left);
            preOrder(root.right);

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
        C.right=F;
        D.left=G;
        E.right=H;

      Node result=isOfValue(root,'I');
        if(result!=null) {
            System.out.println(result.value);
        }else{

            System.out.println("在该二叉树中不存在该值");
        }




      /*  Node n1=new Node('D');
        Node n2= new Node('G');
        n1.left=n2;*/
        //Node result2=isOfTree(root,n1);// //这种写法是错的,要用下面的那种写发，n1与D不是同一个结点


        Node result2=isOfTree(root,D);
        preOrder(result2);
    }



}
