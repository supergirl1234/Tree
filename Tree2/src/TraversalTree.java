import java.util.Stack;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 * 非递归前序遍历二叉树  用到了栈
 * 非递归中序遍历二叉树  用到了栈
 */
public class TraversalTree {

  //非递归前序遍历二叉树
  public static  void preOrderNode(Node root){
    Stack<Node> stack=new Stack<>();
    Node cur=root;

    while(!stack.isEmpty()||cur!=null) {
      while (cur != null) {

        //优先向左走
        //第一次遇到cur这个结点就输出
        System.out.print(cur.value);
        //首先将左结点入栈
        stack.push(cur);
        cur = cur.left;
      }
      //向左走到头了，需要回溯
      //目前栈里的所有结点的右子树都没有进行遍历
      Node top = stack.pop();
      cur = top.right;
    }

  }

  //非递归中序遍历二叉树
  public static  void inOrderNode(Node root){

    Stack<Node> stack=new Stack<>();
    Node cur=root;
    while(!stack.isEmpty()||cur!=null){

      while (cur!=null){

        stack.push(cur);
        cur=cur.left;
      }
      Node top=stack.pop();
      //第二次遇到该节结点才输出
      System.out.print(top.value);
      cur=top.right;
    }

  }

  //非递归后序遍历二叉树
  public static  void postOrderNode(Node root){


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
    preOrderNode(root);
    System.out.println();
    inOrderNode(root);
  }
}
