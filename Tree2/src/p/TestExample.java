package p;

import p.Test;
import p.Tester;

/**
 * Author:Fanleilei
 * Created:2019/4/20 0020
 */

@Tester(
        author="Fanleilei",
        date="2019-4-20"

)
public class TestExample {

    @Test
    public void testA(){

        throw new RuntimeException("永远失败");
    }

    @Test(enable=true)
    public void testB(){
        if(false) {
            throw new RuntimeException("永远成功");
        }
    }
    @Test(enable=false)
    public void testC(){

        throw new RuntimeException("永远失败");
    }

    public void testD(){

        throw new RuntimeException("永远失败");
    }
}
