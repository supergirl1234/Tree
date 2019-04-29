import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/25 0025
 */
public class Sort {

    //选择排序   找大的
    public static void selectSort(int[] array){
       for(int i=0;i<array.length;i++){

           int max=0;
           for(int j=1;j<array.length-i;j++){
               if(array[j]>array[max]){
                   max=j;

               }

           }

           //将最大的放到最后
           int t=array[max];
           array[max]=array[array.length-i-1];
           array[array.length-i-1]=t;
       }

    }

    //找小的
    public static void selectSort2(int[] array){

        for(int i=0;i<array.length;i++){
            //有序的[0,i）
            //无序的[i,length）
            //假设最小的数的下标为
            //int min=array.length-1;
             int min=i;
          for(int j=array.length-1;j>=i;j--){

              if(array[j]<array[min]){

                  min=j;
              }
          }

          //将最小的放在最前面
            int t=array[min];
            array[min]=array[i];
            array[i]=t;


        }
    }

    //堆排序(从小到大)  首先要是一个堆，才能开始排序
    //需要先建成堆（大堆），然后将最大的数（array[0]）和最后一个数交换位置，
    // 再接着，建成堆后，再将最大的数与最后一个数（不包括刚刚弄下来的那个最大的数）交换位置，以此类推
    public static void heapSort(int[] array){
        //先将数组构建成一个大堆
        createHeap(array);
        //将最大的数array[0]与最后一个叶子节点互换位置
        for(int i=0;i<array.length;i++){

            int t=array[array.length-1-i];
            array[array.length-1-i]=array[0];
            array[0]=t;

            heapify(array,0,array.length-1-i);


        }
    }

    //将数组构建成一个大堆
    public static void createHeap(int[] array){
        //从最后一个非叶子节点开始
        int index=(array.length-1-1)/2;
        while(index>=0){
            heapify(array,index,array.length);
            index--;
        }
    }
    //将某一个节点向下调整，使整个树变成一个堆
    public static  void heapify(int[] array,int index,int size){
         //先判断该节点是不是叶子节点，如果该结点是叶子节点，就不进行向下调整了
          if(2*index+1>=size){
              return;

          }
          //找出该节点的孩子节点中最大的那个数的下标
          //左孩子
          int max=2*index+1;
          //如果存在右孩子
          if(max+1<size&&array[max+1]>array[max]){
              max=max+1;

          }

          //判断该节点和孩子节点中最大的那个 哪个大
            //如果该节点值大，则就不进行了
            /*if (array[index]>array[max]) {
                return;
            }
            //否则
            //互换位置
            int t=array[max];
            array[max]=array[index];
            array[index]=t;

            //继续进行向下调整
            heapify(array,max,size);*/

        if (array[index]<array[max]) {
            //互换位置
            int t=array[max];
            array[max]=array[index];
            array[index]=t;

            //继续进行向下调整
            heapify(array,max,size);
        }



    }

    public static void main(String[] args) {
        int[] array = { 9, 5, 2, 7, 3, 6, 8, 8, 4, 9, 3, 1, 2 };
        //selectSort2(array);
        heapSort(array);
       /* int[] array = { 12, 9, 8, 7, 6, 4, 3, 4, 3, 8, 3, 2, 1,2,1,2,2,2,1,7,3 };
        heapify(array,4,18);*/
        System.out.println(Arrays.toString(array));
    }
}
