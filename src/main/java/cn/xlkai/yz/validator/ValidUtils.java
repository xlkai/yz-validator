package cn.xlkai.yz.validator;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description 工具类
 */
public class ValidUtils {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 判断对象是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        }
        if (String.class.isAssignableFrom(value.getClass())) {
            return isEmpty((String) value);
        } else if (Collection.class.isAssignableFrom(value.getClass())) {
            return ((Collection) value).isEmpty();
        } else if (Map.class.isAssignableFrom(value.getClass())) {
            return ((Map) value).isEmpty();
        }
        return false;
    }

    public static List<Field> getAllFieldList(Class<?> cls) {
        Class<?> supperCls = cls;
        List<Field> fieldList = new ArrayList<>();
        while (supperCls != null) {
            Field[] fields = supperCls.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            supperCls = supperCls.getSuperclass();
        }
        return fieldList;
    }

    public static Field[] getAllFields(Class<?> cls) {
        return getAllFieldList(cls).toArray(new Field[0]);
    }
}
