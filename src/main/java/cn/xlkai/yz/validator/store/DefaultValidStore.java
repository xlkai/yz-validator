package cn.xlkai.yz.validator.store;

import cn.xlkai.yz.validator.ValidModel;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description DefaultValidStore.java
 */
public class DefaultValidStore implements ValidStore {

    private Field[] fields;
    private Map<String, List<ValidModel>> validMap;

    public DefaultValidStore(Field[] fields, Map<String, List<ValidModel>> validMap) {
        this.fields = fields;
        this.validMap = validMap;
    }

    @Override
    public Field getField(String fieldName) throws NoSuchFieldException {
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        throw new NoSuchFieldException("Not found field by name[" + fieldName + "]");
    }

    @Override
    public List<ValidModel> valids(String id) {
        return validMap.getOrDefault(id, Collections.emptyList());
    }
}
