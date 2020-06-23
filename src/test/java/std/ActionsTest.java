package std;

import org.junit.*;
import std.utils.Actions;
import static org.junit.Assert.assertEquals;


import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by anna on 22.06.20.
 */
public class ActionsTest {

    private NumberFormat number = new DecimalFormat("##0.###");
    private JFormattedTextField jTextFieldA = new JFormattedTextField(new NumberFormatter(number));
    private JFormattedTextField jTextFieldB = new JFormattedTextField(new NumberFormatter(number));


    @Test
    public void testCalc_area_25() throws Exception {
        jTextFieldA.setValue(new Double("5.0"));
        jTextFieldB.setValue(new Long("5"));
        assertEquals("Площадь прямоугольника должна быть равна 25 см, при величине обоих сторон 5 и 5 см.", Actions.calc_area(jTextFieldA.getValue(), jTextFieldB.getValue()), new BigDecimal("25.00"));

    }

    @Test
    public void testCalc_area_29_00() throws Exception {
        jTextFieldA.setValue(new Double("5.8"));
        jTextFieldB.setValue(new Long("5"));
        assertEquals("Площадь прямоугольника должна быть равна 29 см, при величине обоих сторон 5.8 и 5 см.", Actions.calc_area(jTextFieldA.getValue(), jTextFieldB.getValue()), new BigDecimal("29.00"));
    }
    @Test
    public void testCalc_area_4_4() throws Exception {
        jTextFieldA.setValue(new Double("2.2"));
        jTextFieldB.setValue(new Long("2"));
        assertEquals("Площадь прямоугольника должна быть равна 29 см, при величине обоих сторон 5.8 и 5 см.", Actions.calc_area(jTextFieldA.getValue(), jTextFieldB.getValue()), new BigDecimal("4.40"));
    }

    @Test(expected = NumberFormatException.class)
    public void testCalc_area_string() throws NumberFormatException {
        jTextFieldA.setValue(new BigDecimal("AAA"));
        jTextFieldB.setValue(new BigDecimal("BBB"));
    }

}
