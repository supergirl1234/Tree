import java.util.*;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 * 层序遍历的变形
 * {
 *     {}
 *     {}
 *     {}
 * }
 *
 */
public class TraversalLevelOrder2 {
    private static List<List<Character>> levelOrderTrave2(Node root) {

        List<List<Character>> list=new ArrayList<>();
        if(root==null){
            return list;

        }

        class NodeLevel{

            Node node;
            int level;

            public NodeLevel(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        Queue<NodeLevel> queue=new LinkedList<>() ;

        queue.add(new NodeLevel(root,0));
        while (!queue.isEmpty()) {
            NodeLevel front=queue.poll();
            Node node=front.node;
            int level=front.level;
            //处理返回值
            if(list.size()==level){
                list.add(new ArrayList<>());

            }
            list.get(level).add(node.value);
            if(node.left!=null){
                queue.add(new NodeLevel(node.left,level+1));


            }
            if(node.right!=null){
                queue.add(new NodeLevel(node.right,level+1));


            }
        }

        return list;


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

        List<List<Character>> list= levelOrderTrave2(root);
        System.out.println("{");
        for(List<Character> entry:list){
            System.out.println("  "+entry);

        }
        System.out.println("}");
    }


}
