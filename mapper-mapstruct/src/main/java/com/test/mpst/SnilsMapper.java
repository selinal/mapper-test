package com.test.mpst;

import com.test.mapper.Snils;

/**
 * Created by SBT-Selin-AN on 27.06.2016.
 */
public class SnilsMapper {

    public Snils asSnils(String snils) {
        if (snils != null) {
            Snils snils1 = new Snils();
            snils1.setCode(snils);
            return snils1;
        } else return null;
    }

    ;

    public String asString(Snils snils) {
        if (snils != null)
            return snils.getCode();
        else return null;
    }

}
