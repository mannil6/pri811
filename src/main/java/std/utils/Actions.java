package std.utils;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by anna on 22.06.20.
 */
public class Actions {
    public static BigDecimal calc_area(Object a, Object b) {
        BigDecimal a_side = BigDecimal.ZERO;
        BigDecimal b_side = BigDecimal.ZERO;

        if (a instanceof Double) {
            a_side = new BigDecimal((Double) a, MathContext.DECIMAL32);
            a_side.setScale(2, 1);
        }
        if (a instanceof Long) {
            a_side = new BigDecimal((Long) a);
        }
        if (b instanceof Double) {
            b_side = new BigDecimal((Double) b, MathContext.DECIMAL32);
            b_side.setScale(2, 1);
        }
        if (b instanceof Long) {
            b_side = new BigDecimal((Long) b);
        }
        BigDecimal area = a_side.multiply(b_side);
        area = area.setScale(2, 0);
        return area;

    }

    public static Boolean check(Object object) {
        if (object == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
