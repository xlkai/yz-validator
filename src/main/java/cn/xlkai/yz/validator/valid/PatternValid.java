package cn.xlkai.yz.validator.valid;

import cn.xlkai.yz.validator.ValidModel;
import cn.xlkai.yz.validator.ValidUtils;

import java.util.regex.Pattern;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description 正则校验
 */
public class PatternValid implements IValid {

    @Override
    public boolean valid(Object value, ValidModel valid) {
        if (ValidUtils.isEmpty(value) || ValidUtils.isEmpty(valid.getPattern())) {
            return true;
        }
        return Pattern.matches(valid.getPattern(), value.toString());
    }

    @Override
    public String getMsg(ValidModel valid) {
        String msg = valid.getPatternMsg();
        return msg.replace("#{name}", valid.getName());
    }

}
