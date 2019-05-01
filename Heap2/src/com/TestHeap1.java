package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/1 0001
 */
public class TestHeap1 {



    //建堆  就是从最后一个非叶子结点开始，一步一步的进行堆化
    //建大堆
    private static void createHeap(int[] array){
        //最后一个非叶子结点
        int index=(array.length-1-1)/2;
        while(index>=0){
            heapify(array,index);
            index--;

        }


    }

    //堆化为大堆
    //堆化(向下调整)  前提是 只有一个地方不满足堆的性质，其他位置都满足堆的性质
    private static void heapify(int[] array,int index){
        //看该节点是不是叶子结点
        //其左孩子节点下标
       int max=2*index+1;
       //如果左孩子下标超过数组长度，则该结点是叶子结点
       if(max>=array.length){
           return;

       }
       //找出孩子结点中值最大的结点下标
       if(max+1<array.length&&array[max+1]>array[max]){
           max=max+1;

       }

       //比较该根结点与最大的孩子结点的大小，如果孩子结点大，则换位置
        if(array[index]<array[max]){
           int t=array[index];
           array[index]=array[max];
           array[max]=t;
           //换完之后，在该index结点处满足堆的性质了，
           //但是在max位置，其与它的孩子结点不一定满足堆的性质了，在max位置继续进行堆化
           heapify(array,max);

        }

    }

    //向上调整  使其成为一个大堆  前提也是 只有一个地方不满足堆的性质，其他位置都满足堆的性质

    //向下调整是该结点与其孩子结点相比较
    //但向上调整是该结点与其父亲结点相比较

    private static void adjustUp(int[] array,int index){

        //向上调整到下标为0的位置就不调整了
        if(index==0){
            return;

        }
        //其父亲结点
        int parent=(index-1)/2;

        //与父亲结点相比较
        //如果父亲节点的值小，就交换位置，否则就不调整了
        if(array[parent]<array[index]){
            int t=array[parent];
            array[parent]=array[index];
            array[index]=t;

            //继续向上调整
            adjustUp(array,parent);

        }

    }

    public static void main(String[] args) {

        int[] array = new int[]{14, 10, 9, 7, 12, 2, 1, 4, 3, 11, 5};

        heapify(array, 1);
        System.out.println(Arrays.toString(array));


        int[] array1=new int[]{11,10,9,7,12,2,1,4,3,0,5};
        adjustUp(array1,4);

        System.out.println(Arrays.toString(array1));


        int[] array3=new int[]{1,2,3,4,5,6,7,8,9,10};
        createHeap(array3);

        System.out.println(Arrays.toString(array3));

    }
}
