package ru.mirea.kvbo0422.task15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.SystemColor.info;

public class Menu implements ItemListener{
        JFrame f1;
        TextArea t;
        JComboBox c;
        JPanel p ;
        JLabel j;
        String info [] = {"Information about Australia", "Information about China", "Information about England", "Information about Russia"};
        Menu()
        {
            JFrame f1 = new JFrame("Selection");
            Container f = new Container();
            f.setLayout(new FlowLayout());

            String s [] = {"Australia","China","England","Russia"};

            c = new JComboBox(s);
            j = new JLabel();
            p = new JPanel();
            t = new TextArea();

            c.addItemListener(this);

            f1.add(p);
            p.add(c);
            p.add(j);
            p.add(t);

            f1.setSize(600,300);
            f1.setVisible(true);

        }
        public void itemStateChanged(ItemEvent ie)
        {
            String str = (String)c.getSelectedItem();
            j.setText(str);
            switch (str){
                case "Russia" ->{
                    t.setText(info[0]);
                }
                case "Australia" ->{
                    t.setText(info[1]);
                }
                case "England" ->{
                    t.setText(info[2]);
                }
                case "China" ->{
                    t.setText(info[3]);
                }
            }

        }
        public static void main(String[] args) {
            Menu l = new Menu();
        }
    }

