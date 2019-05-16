package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/7 0007
 */
public class Test1 {


    //求第k层结点个数
    private static int getKLevelSize(Node root,int k){
        if(root==null){
            return 0;
        }

        if(k==1){

            return 1;
        }

       return getKLevelSize(root.left,k-1)  +getKLevelSize(root.right,k-1);


    }


    //插排
    private static void insertSort(int[] array){
        //有序[0,i) 无序[i,array.length-1)
        for(int i=0;i<array.length;i++){

            int key=array[i];//要插入的数
            int j=i-1;
            for(;j>=0;j--){
                if(key<array[j]){
                    array[j+1]=array[j];

                }else{

                    //找到array[i]应该插入的位置了
                    break;
                }


            }
            array[j+1]=key;


        }


    }


    public static void main(String[] args) {

        int[] array=new int[]{2,1,4,5,7,3,5};
        insertSort(array);
        System.out.println(Arrays.toString(array));



    }
}
