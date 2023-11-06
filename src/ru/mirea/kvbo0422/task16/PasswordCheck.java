
package ru.mirea.kvbo0422.task16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;


public class PasswordCheck {
        JFrame f;
        JPanel p;
        JTextField service = new JTextField(18);
        JTextField userName = new JTextField(18);
        JTextField password = new JTextField(18);
        JLabel servLabel = new JLabel("Service");
        JLabel userLabel = new JLabel("User name");
        JLabel passLabel = new JLabel("Password");
        String serviceValues = "Youtube";
        String userValues = "admin";
        String passwordValues = "012345678910";
        Integer state = 0;
        PasswordCheck(){
            prepareGUI();
            addTextFieldsAndLabels();
            addActions();
        }
        public void prepareGUI(){
            //Frame nad panel
            f = new JFrame();
            f.setTitle("Password applicatiob");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(300,130);
            f.setResizable(false);
            f.setVisible(true);

            p = new JPanel();
            p.setLayout(new GridLayout(3,2,5,10));

        }
        public void addActions(){
            service.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        if (Objects.equals(service.getText(), serviceValues)){
                            state++;
                        }
                        userName.requestFocusInWindow();
                    }
                }

            });
            userName.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        if (Objects.equals(userName.getText(), userValues)){
                            state++;
                        }
                        password.requestFocusInWindow();
                    }
                }

            });
            password.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        if (Objects.equals(userName.getText(), userValues)){
                            state++;
                        }
                        if (state == 3){
                            service.setBackground(Color.GREEN);
                            userName.setBackground(Color.GREEN);
                            password.setBackground(Color.GREEN);
                            state =0 ;
                        }
                        else {
                            service.setBackground(Color.RED);
                            service.setBackground(Color.RED);
                            userName.setBackground(Color.RED);
                            password.setBackground(Color.RED);
                            state = 0;
                        }
                        service.requestFocusInWindow();
                    }
                }

            });
        }
        public void addTextFieldsAndLabels(){
            //labels and textfields
            p.add(servLabel);
            p.add(service);
            p.add(userLabel);
            p.add(userLabel);
            p.add(userName);
            p.add(passLabel);
            p.add(password);
            f.add(p);
        }
        public static void main(String[] args) {
            new PasswordCheck();

        }
    }

