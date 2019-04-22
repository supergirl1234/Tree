/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 * 找结点的最近的公共祖先
 * 先判断两个结点是否和根结点相等，只要有一个相等，则其最近的公共祖先为root
 * 再判断两个结点是否在都在root的左子树上或右子树上
 * 如果两个结点分别在root的左子树和右子树上，则其最近的公共祖先为root
 * 如果两个结点都在root的左子树上或右子树上，则在root的左子树或右子树上再一次进行上面的查找。
 */
public class SearchLowComAncestor {


    public static Node searchLowAncestor(Node root,Node v1,Node v2){

        if(root==v1||root==v2){
            return  root;

        }
        //判断两个结点v1、v2是否在都在root的左子树上或右子树上
        //在左子树上查找,都在左子树上，则在左子树上查找

        boolean voneBoolean=find(root.left,v1);
        boolean vtwoBoolean=find(root.left,v2);
        if(voneBoolean&&vtwoBoolean){
           return searchLowAncestor(root.left,v1,v2);

        }else if(!voneBoolean&&!vtwoBoolean){
        //都在右子树上，则在右子树上查找

           return searchLowAncestor(root.right,v1,v2);

        }else {
        //如果v1、v2分别在root的左子树和右子树上，则其最近的公共祖先为root

            return root;
        }



    }
    //查找树中是否包含某个结点

    public static  boolean find(Node root,Node v){
        if(root==null){
            return false;

        }

        if(root==v){
            return true;


        }

        boolean isBoolean=find(root.left,v);
        if(isBoolean){
            return  true;
        }
        isBoolean=find(root.right,v);
        if(isBoolean){

            return true;
        }
        return false;

    }


    public static void main(String[] args) {

        Node root = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node A= new Node('H');



        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        C.right = F;
        D.left = G;
        E.right = H;
/*
        boolean result=find(root,C);
        System.out.println(result);*/

        //Node re=searchLowAncestor(root,D,C);
        Node re=searchLowAncestor(root,D,G);

        System.out.println(re.value);

    }
}
