package com.p;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/5/10 0010
 */
public class Test {


    private static void testList(List<Integer> list){

        list.clear();

        for(int i=0;i<10;i++){

            list.add(i);
        }


        Iterator<Integer>  iterator=list.iterator();
        while(iterator.hasNext()){

            int item=iterator.next();
            System.out.print(item+" ,");
        }
        System.out.println();

        iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            System.out.print(item + ", ");
            if (item == 5) {
                iterator.remove();
            }
        }
        System.out.println();


        iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            System.out.print(item + ", ");

        }
        System.out.println();


        System.out.println(list);
    }


    public static void main(String[] args) {

        List<Integer> arrayList=new ArrayList<>();
        testList(arrayList);

        List<Integer> seqList=new SeqList<>();
        testList(seqList);

      



    }
}
