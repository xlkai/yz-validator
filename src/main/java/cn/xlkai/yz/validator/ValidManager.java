package cn.xlkai.yz.validator;

import cn.xlkai.yz.validator.custom.Validator;
import cn.xlkai.yz.validator.provider.IProvider;
import cn.xlkai.yz.validator.store.ValidStore;
import cn.xlkai.yz.validator.valid.IValid;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description ValidManager.java
 */
public class ValidManager {

    public static final String DEFAULT_NAME = "_DEFAULT_";

    @SuppressWarnings("unchecked")
    public static void valid(ValidProvider provider, Object object, String id) throws ValidException {
        try {
            if (ValidUtils.isEmpty(id)) {
                id = DEFAULT_NAME;
            }
            ValidStore store = provider.getProvider().get(object.getClass());
            for (ValidModel valid : store.valids(id)) {
                Field field = store.getField(valid.getFieldName());
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object value = field.get(object);

                // 系统默认校验规则
                for (IValid mValid : provider.getValids()) {
                    if (!mValid.valid(value, valid)) {
                        throw new ValidException(mValid.getMsg(valid));
                    }
                }

                //自定义校验规则
                for (Class<? extends Validator> cls : valid.getValidClass()) {
                    if (!cls.isInterface()
                            && !Modifier.isAbstract(cls.getModifiers())) {
                        Validator validator = cls.newInstance();
                        validator.valid(object, value, valid);
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void valid(Object object, String id) throws ValidException {
        valid(IProviderHolder.provider, object, id);
    }

    public static void valid(Object object) throws ValidException {
        valid(object, null);
    }

    /**
     * 懒加载{@link IProvider}
     */
    private static final class IProviderHolder {
        private static final ValidProvider provider = new DefaultValidProvider();
    }
}
