package cn.xlkai.yz.test.validator;

import cn.xlkai.yz.validator.Valid;
import cn.xlkai.yz.validator.ValidManager;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description TestModel.java
 */
@Data
public class TestModel {

    @Valid(name = "String", id = {"testId", ValidManager.DEFAULT_NAME}, max = 4, min = 4)
    private String stringVal;
    @Valid(name = "Float", scale = 1)
    private Float floatVal;
    @Valid(name = "Double")
    private Double doubleVal;
    @Valid(name = "Int")
    private Integer intVal;
    @Valid(name = "Long")
    private Long longVal;
    @Valid(name = "List")
    private List<String> listVal;
    @Valid(name = "Map")
    private Map<String, String> mapVal;

}
