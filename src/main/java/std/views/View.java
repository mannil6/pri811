package std.views;

import std.utils.Actions;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by anna on 22.06.20.
 */
public class View extends JFrame {
    private NumberFormat number = new DecimalFormat("##0.###");

    public View() {
        super();
        setTitle("Программа вычисления площади прямоугольника");
        setBounds(500, 400, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout((FlowLayout.LEADING)));

        panel.add(new JLabel("Сторона прямоугольника А (см.)"));
        final JFormattedTextField jTextFieldA = new JFormattedTextField(new NumberFormatter(number));
        jTextFieldA.setColumns(10);
        panel.add(jTextFieldA);

        panel.add(new JLabel("Сторона прямоугольника Б (см.)"));
        final JFormattedTextField jTextFieldB = new JFormattedTextField(new NumberFormatter(number));
        jTextFieldB.setColumns(10);
        panel.add(jTextFieldB);

        final JFormattedTextField jTextField_area = new JFormattedTextField(new NumberFormatter(number));
        jTextField_area.setColumns(10);

        JButton jButton = new JButton("Посчитать площадь");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Actions.check(jTextFieldA.getValue()) && Actions.check(jTextFieldB.getValue())) {
                    jTextField_area.setValue(Actions.calc_area(jTextFieldA.getValue(), jTextFieldB.getValue()));
                } else {
                    visibleInfoDialog();
                }
            }
        });
        panel.add(jButton);

        panel.add(new JLabel("Площадь прямоугольника (см.)"));
        panel.add(jTextField_area);

        this.add(panel);

    }


    /**
     * Показывает информационное окно.
     */

    private void visibleInfoDialog() {
        JDialog jDialog = new JDialog(this, "Внимание!", true);
        jDialog.setBounds(700, 100, 700, 100);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout((FlowLayout.LEADING)));

        panel.add(new JLabel("Для вычисления площади необходимо заполнить значения сторон прямоугольника цифрами."));
        jDialog.add(panel);
        jDialog.setVisible(true);
    }


}
