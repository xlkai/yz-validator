package cn.xlkai.yz.validator.valid;

import cn.xlkai.yz.validator.ValidModel;
import cn.xlkai.yz.validator.ValidUtils;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description 小数校验
 */
public class DecimalValid implements IValid {

    @Override
    public boolean valid(Object value, ValidModel valid) {
        if (ValidUtils.isEmpty(value) || !Number.class.isAssignableFrom(value.getClass())) {
            return true;
        }
        if ((Float.class.isAssignableFrom(value.getClass())
                || Double.class.isAssignableFrom(value.getClass())) && valid.getScale() > 0) {
            return getDecimalLength(value) <= valid.getScale();
        }
        return true;
    }

    @Override
    public String getMsg(ValidModel valid) {
        return valid.getName() + "必须保留" + valid.getScale() + "位小数";
    }

    /**
     * 获取小数位数
     *
     * @param value
     * @return
     */
    private static int getDecimalLength(Object value) {
        String[] strings = value.toString().split("\\.");
        if (strings.length == 2) {
            for (; ; ) {
                if (strings[1].endsWith("0")) {
                    strings[1] = strings[1].substring(0, strings[1].length() - 1);
                } else {
                    break;
                }
            }
            return strings[1].length();
        }
        return 0;
    }
}
