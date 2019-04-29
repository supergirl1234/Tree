import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/25 0025
 */
public class Heap2 {

    //向上调整   向上调整是被调整的节点与它的父节点相比较；
             // 而向下调整是被调整的结点与它的孩子节点相比较
             //但它们的前提条件都是：只有一个位置不满足堆的性质，其它位置都满足堆的性质
    public static void adjustUp(int[] array,int index){

        if(index==0){

          return;
        }

        int parent=(index-1)/2;
        if(array[parent]>=array[index]){

          return;
        }
        int t=array[parent];
        array[parent]=array[index];
        array[index]=t;

        adjustUp(array,parent);


    }

    public static void main(String[] args) {

        int[] array = { 9,8,4,5,6,1,3,7,3,2 };

        adjustUp(array,7);
        System.out.println(Arrays.toString(array));
    }

}
