package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/1 0001
 */
public class Sort {

    //堆排序

    private static void heapSort(int[] array){

        //首先需要创建一个大堆
        createHeap(array);

        for (int i= 0; i < array.length; i++) {
            //然后将最大的数array[0]与最后一个数(不包括之前换下来的最大的那个数)互换位置
            int t=array[0];
            array[0]=array[array.length-1-i];
            array[array.length-1-i]=t;

            //不包括最后一个换下来的最大的一个数，再进行堆化
            heapify(array,0,array.length-1-i);//进行堆化的长度变了，就是堆化时，不包括之前换下来的最大的数了

        }


    }
    private static void createHeap(int[] array){
        //最后一个非叶子结点
        int index=(array.length-1-1)/2;
        while(index>=0){
            heapify(array,index,array.length);
            index--;

        }


    }

    //堆化为大堆
    //堆化(向下调整)  前提是 只有一个地方不满足堆的性质，其他位置都满足堆的性质
    private static void heapify(int[] array,int index,int size){
        //看该节点是不是叶子结点
        //其左孩子节点下标
        int max=2*index+1;
        //如果左孩子下标超过数组长度，则该结点是叶子结点
        if(max>=size){
            return;

        }
        //找出孩子结点中值最大的结点下标
        if(max+1<size&&array[max+1]>array[max]){
            max=max+1;

        }

        //比较该根结点与最大的孩子结点的大小，如果孩子结点大，则换位置
        if(array[index]<array[max]){
            int t=array[index];
            array[index]=array[max];
            array[max]=t;
            //换完之后，在该index结点处满足堆的性质了，
            //但是在max位置，其与它的孩子结点不一定满足堆的性质了，在max位置继续进行堆化
            heapify(array,max,size);

        }

    }
    public static void main(String[] args) {

        //int[] array=new int[]{1,2,3,4,5,6,7,8,9,10};
       int[] array=new int[]{2,5,8,9,10,3,16,6,7,14};
        //createHeap(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
