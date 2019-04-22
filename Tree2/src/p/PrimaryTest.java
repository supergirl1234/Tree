package p;

import java.lang.annotation.Annotation;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 */
public class PrimaryTest {

    public static void main(String[] args) throws ClassNotFoundException {

        String classname="TestExample";


        //根据字符串找到类
        Class testClass=Class.forName(classname);

        //如果testClass这个类上有这个注解，就执行
        if(testClass.isAnnotationPresent(Tester.class)){

            Annotation annotation=testClass.getAnnotation(Tester.class);
                Tester tester=(Tester) annotation;
                System.out.println(tester.author());
                System.out.println(tester.date());
        }

    }
}
