import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/25 0025
 */
public class Heap1 {


    //堆化  前提：只有一个位置不满足堆的位置，其他位置都1满足堆的性质
    public static void heapify(int[] tree,int index){//时间复杂度log（n）
        //前提是大堆
        //先判断index处是否是叶子结点，如果是，就不堆化了
        //index的左孩子结点
        int left=2*index+1;
        if(left>=tree.length){
            return;
        }

        //如果不是叶子结点，就进行堆化
        //找孩子结点中的最大值
        int max=left;
        //如果存在右孩子
        int right=2*index+2;
        if(right<tree.length&&tree[right]>tree[left]){
            max=right;

        }

        //判断index结点和孩子结点的最大值

        if (tree[index]>tree[max]){
            return;
        }
        //不满足大堆，则将index节点与其孩子节点互换
        int t=tree[index];
        tree[index]=tree[max];
        tree[max]=t;


        heapify(tree,max);

    }

    //另一种写法
    public static void adjustDown(int[] tree,int index){


        //如果不是叶子结点，就进行循环
        while(2*index+1<tree.length){
            int max=2*index+1;
            //如果index的右孩子的节点值大于左孩子的节点值
            if(max+1<tree.length&&tree[max+1]>tree[index]){

                max=max+1;
            }

            //判断根节点和孩子谁大
            if(tree[max]>tree[index]){
                //互换位置
                int t=tree[index];
                tree[index]=tree[max];
                tree[max]=t;

                index=max;

            }

        }

    }


    //建堆
    public static void createHeap(int[] array){

        //从最后一个非叶子结点开始堆化
        int index=(array.length-2)/2;
        while(index>=0) {
            heapify(array, index);
            index--;
        }


    }

    public static void main(String[] args) {

        int[] array = { 9, 3, 1, 5, 2, 4, 3, 8, 7, 6 };
        createHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
