package cn.xlkai.yz.test.validator;

import cn.xlkai.yz.validator.ValidException;
import cn.xlkai.yz.validator.ValidManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description ValidTest.java
 */
public class ValidTest {

    @Test
    public void testValid() {
        TestModel model = new TestModel();
        model.setId("123456");
        model.setName("t2222");
        model.setPrice(12.435f);
        model.setSex(1);
        model.setSale(100.4526d);
        model.setList(new ArrayList<>(Arrays.asList("1", "2")));
        model.setMap(new HashMap<>());

        long start = System.currentTimeMillis();
        try {
            ValidManager.valid(model);
        } catch (ValidException e) {
            System.out.println(System.currentTimeMillis()-start);
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
