package cn.xlkai.yz.test.validator;

import cn.xlkai.yz.validator.Valid;
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

    private String id;
    @Valid(min = 5, max = 8)
    private String name;
    private Integer sex;
    @Valid(scale = 2)
    private Float price;
    @Valid(scale = 3)
    private Double sale;
    private List<String> list;
    private Map<String, Object> map;

}
