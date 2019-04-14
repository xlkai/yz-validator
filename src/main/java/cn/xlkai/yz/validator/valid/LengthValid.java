package cn.xlkai.yz.validator.valid;

import cn.xlkai.yz.validator.ValidModel;
import cn.xlkai.yz.validator.ValidUtils;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description 长度校验
 */
public class LengthValid implements IValid {

    @Override
    public boolean valid(Object value, ValidModel valid) {
        if (ValidUtils.isEmpty(value)) {
            return true;
        }
        if (valid.getMin() > valid.getMax()) {
            System.err.println("min[" + valid.getMin() + "]不能大于max[" + valid.getMax() + "]");
            return true;
        }
        String str = value.toString();
        return str.length() >= valid.getMin() && str.length() <= valid.getMax();
    }

    @Override
    public String getMsg(ValidModel valid) {
        if (valid.getMin() == valid.getMax()) {
            return valid.getName() + "必须为" + valid.getMax() + "字符";
        } else if (valid.getMin() == 0) {
            return valid.getName() + "不能大于" + valid.getMax() + "字符";
        } else {
            return valid.getName() + "必须" + valid.getMin() + "-" + valid.getMax() + "字符";
        }
    }

}
