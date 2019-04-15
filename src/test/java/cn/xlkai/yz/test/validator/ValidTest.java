package cn.xlkai.yz.test.validator;

import cn.xlkai.yz.validator.ValidException;
import cn.xlkai.yz.validator.ValidManager;
import org.junit.Test;

import java.util.ArrayList;
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
        model.setStringVal("string");
        model.setDoubleVal(0d);
        model.setFloatVal(0.23f);
        model.setIntVal(1);
        model.setLongVal(1L);
        model.setListVal(new ArrayList<>());
        model.setMapVal(new HashMap<>());

        try {
            ValidManager.valid(model);
        } catch (ValidException e) {
            e.printStackTrace();
        }

        try {
            ValidManager.valid(model, "testId");
        } catch (ValidException e) {
            e.printStackTrace();
        }
    }

}
