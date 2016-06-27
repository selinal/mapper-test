package com.test.mpst;

import com.test.mapper.BaseSnils;
import org.mapstruct.TargetType;

/**
 * Created by SBT-Selin-AN on 27.06.2016.
 */
public class SnilsTypeMapper{

    public <T extends BaseSnils> T resolve(String value, @TargetType Class<T> entityClass) throws IllegalAccessException, InstantiationException {
        T t = entityClass.newInstance();
        t.setCode(value);
        return t;
    }

    public String toString(BaseSnils entity) {
        return entity.getCode();
    }
}
