package cn.xlkai.yz.validator;

import cn.xlkai.yz.validator.provider.DefaultProvider;
import cn.xlkai.yz.validator.provider.IProvider;
import cn.xlkai.yz.validator.valid.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description DefaultValidProvider.java
 */
public class DefaultValidProvider implements ValidProvider {

    private static final IProvider provider = new DefaultProvider();
    private static List<IValid> valids = new ArrayList<>();

    static {
        valids.add(new NullableValid());
        valids.add(new PatternValid());
        valids.add(new LengthValid());
        valids.add(new DecimalValid());
    }

    @Override
    public List<IValid> getValids() {
        return valids;
    }

    @Override
    public IProvider getProvider() {
        return provider;
    }


}
