package cn.xlkai.yz.validator.provider;

import cn.xlkai.yz.validator.Valid;
import cn.xlkai.yz.validator.ValidModel;
import cn.xlkai.yz.validator.ValidUtils;
import cn.xlkai.yz.validator.Valids;
import cn.xlkai.yz.validator.store.DefaultValidStore;
import cn.xlkai.yz.validator.store.ValidStore;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description DefaultProvider.java
 */
public class DefaultProvider implements IProvider {

    @Override
    public ValidStore get(Class<?> cls) {
        Field[] fields = ValidUtils.getAllFields(cls);
        Map<String, List<ValidModel>> validMap = new HashMap<>();
        for (Field field : fields) {
            Valids validsAnn = field.getAnnotation(Valids.class);
            if (validsAnn != null) {
                String name = validsAnn.name().length() > 0 ? validsAnn.name() : field.getName();
                for (Valid validAnn : validsAnn.value()) {
                    addValid(validAnn, name, field.getName(), validMap);
                }
            }

            Valid validAnn = field.getAnnotation(Valid.class);
            if (validAnn != null) {
                addValid(validAnn, field.getName(), field.getName(), validMap);
            }
        }
        return new DefaultValidStore(fields, validMap);
    }

    private void addValid(Valid validAnn, String name, String fieldName, Map<String, List<ValidModel>> validMap) {
        ValidModel model = new ValidModel();
        model.setName(validAnn.name().length() > 0 ? validAnn.name() : name);
        model.setMin(validAnn.min());
        model.setMax(validAnn.max());
        model.setNullable(validAnn.nullable());
        model.setPattern(validAnn.pattern());
        model.setPatternMsg(validAnn.patternMsg());
        model.setScale(validAnn.scale());
        model.setFieldName(fieldName);
        model.setValidClass(validAnn.custom());
        for (String id : validAnn.id()) {
            validMap.computeIfAbsent(id, key -> new ArrayList<>())
                    .add(model);
        }
    }
}
