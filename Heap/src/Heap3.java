import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/4/29 0029
 */
public class Heap3 {

    //向上调整 使其成为大堆
    public static void adjustUp2(int[] array,int index){
        //当调整到根节点时，就不调整了
        if(index==0){
            return;

        }
        //判断该节点与父亲节点的大小

        int parent=(index-2)/2;
        if(array[index]>array[parent]){
            //互换位置
            int t=array[index];
            array[index]=array[parent];
            array[parent]=t;

            adjustUp2(array,parent);

        }


    }

    public static void main(String[] args) {

        int[] array=new int[]{10,9,8,7,11,2,1,6,5,4,3};
        adjustUp2(array,4);
        System.out.println(Arrays.toString(array));
    }
}
