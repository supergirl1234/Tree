package pp;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 *
 *
 *
 */
public class ReservalLinkedList {
    //逆置单链表
    public static Node reverseNode(Node head){

        Node result=null;
        Node cur=head;
        //将链表中的元素头插到result链表中

        while(cur!=null){
            Node node=cur.next;
            //头插
            cur.next=result;
            result=cur;

            cur=node;

        }

        return result;

    }

    //有序链表中删除重复结点
    public static  Node deleteDuplicted(Node head){

        Node node=new Node(0);
        Node pre =node;//前驱结点,
        pre.next=head;

        Node p1=head;
        Node p2=head.next;


        while(p2!=null) {
            if (p1.value != p2.value) {
                pre = pre.next;
                p1 = p1.next;
                p2 = p2.next;

            } else {

                while (p2!=null&&p1.value == p2.value) {

                    p2 = p2.next;
                }

                pre.next = p2;
                p1 = p2;
                if(p2!=null) {
                    p2 = p2.next;
                }
            }
        }

        return node.next;

    }


    //复制链表（每个结点有random、next）
    public static Node2 copyNode(Node2 head){

        //先复制原有的链表，将复制出来的结点和原有的结点合并成一个链表

        Node2 cur=head;

        while(cur!=null){

            Node2 node=new Node2(cur.value);//复制的新结点

            node.next=cur.next;

            cur.next=node;

            //下一个进行复制的结点
            cur=node.next;
        }

        //再复制random，此时复制的结点的random就是原结点的random的next节点
        //从头开始
        cur=head;
        while(cur!=null){
            Node2 node=cur.next;//复制的结点
            if(cur.random!=null) {
                node.random = cur.random.next;
            }else{
                cur.next.random =null;

            }

            cur=cur.next.next;

        }

        //将原有链表与复制的链表拆分
        //从头开始
        cur=head;
        Node2 result=cur.next;//存放复制出来的结点的链表

        while(cur!=null){

           Node2 node=cur.next;//复制的结点
           cur.next=node.next;

           if(node.next==null) {

               node.next=null;

           }else {
               node.next = node.next.next;

           }

            cur=cur.next;

        }

        return result;


    }

    public static void disply(Node head){

        Node cur=head;
        while(cur!=null){

            if(cur.next==null){
                System.out.print(cur.value);

            }else{

                System.out.print(cur.value+"->");
            }
            cur=cur.next;

        }

    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(3);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(6);
        Node node8=new Node(6);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=null;

       /*Node result=reverseNode(node1);
       disply(result);*/

       System.out.println();

       Node result2=deleteDuplicted(node1);
        disply(result2);

    }
}
