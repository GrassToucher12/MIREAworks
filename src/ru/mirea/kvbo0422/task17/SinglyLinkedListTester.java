package ru.mirea.kvbo0422.task17;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SinglyLinkedListTester {
    JFrame f;
    JTextField tf = new JTextField();
    JButton addFirst = new JButton("add first");
    JButton addLast = new JButton("add last");
    JButton removeFirst = new JButton("remove first");
    JTextField add_removeDisplay = new JTextField(10);
    JButton first = new JButton("first element");
    JButton last = new JButton("last element");
    JTextField first_lastDisplay = new JTextField(10);
    public String s = "";
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    SinglyLinkedListTester() {
        prepareGUI();
        addTextField();
        addButtons();
        addActions();
    }

    public void prepareGUI() {
        //Frame
        f = new JFrame();
        f.setBackground(Color.BLACK);
        f.setTitle("Singly linked list manager");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 400);
        f.setResizable(false);
        f.setVisible(true);
    }

    public void addTextField() {
        //TextField 1
        tf = new JTextField(10);
        tf.setBounds(25, 20, 350, 100);
        tf.setFont(new Font("Arial", Font.BOLD, 22));
        tf.setEditable(false);
        tf.setText("Place for you list");
        tf.setBorder(new LineBorder(Color.GRAY, 5, true));
        tf.setBackground(new Color(137, 158, 139));
        f.add("West", tf);

        //TextField 2
        add_removeDisplay.setBounds(25, 20, 350, 100);
        add_removeDisplay.setFont(new Font("Arial", Font.BOLD, 22));
        add_removeDisplay.setText("");
        add_removeDisplay.setBorder(new LineBorder(Color.GRAY, 5, true));
        add_removeDisplay.setBackground(new Color(137, 158, 139));

        //TextField 3
        first_lastDisplay.setBounds(25, 20, 350, 100);
        first_lastDisplay.setFont(new Font("Arial", Font.BOLD, 22));
        first_lastDisplay.setText("");
        first_lastDisplay.setBorder(new LineBorder(Color.GRAY, 5, true));
        first_lastDisplay.setBackground(new Color(137, 158, 139));
    }

    public void addButtons() {
        //Buttons
        JPanel add_removeKeyboard = new JPanel();
        add_removeKeyboard.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.weightx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridx = 0;

        add_removeKeyboard.add(add_removeDisplay, constraints);

        addFirst.setFont(new Font("Arial", Font.BOLD, 14));
        addFirst.setSize(50, 30);
        addFirst.setBackground(Color.GRAY);
        addFirst.setBorder(new LineBorder(Color.WHITE, 2, true));
        addFirst.setForeground(Color.WHITE);

        addLast.setFont(new Font("Arial", Font.BOLD, 14));
        addLast.setSize(50, 30);
        addLast.setBackground(Color.GRAY);
        addLast.setBorder(new LineBorder(Color.WHITE, 2, true));
        addLast.setForeground(Color.WHITE);

        removeFirst.setFont(new Font("Arial", Font.BOLD, 14));
        removeFirst.setSize(50, 30);
        removeFirst.setBackground(Color.GRAY);
        removeFirst.setBorder(new LineBorder(Color.WHITE, 2, true));
        removeFirst.setForeground(Color.WHITE);

        constraints.weightx = 2;
        constraints.weighty = 1.0;
        constraints.gridwidth = 1;

        constraints.gridy = 1;
        constraints.gridx = 0;
        add_removeKeyboard.add(addFirst, constraints);

        constraints.gridy = 1;
        constraints.gridx = 1;
        add_removeKeyboard.add(addLast, constraints);

        constraints.gridy = 1;
        constraints.gridx = 2;
        add_removeKeyboard.add(removeFirst, constraints);

        JPanel first_lastKeyboard = new JPanel();
        first_lastKeyboard.setLayout(new GridLayout(1, 2, 15, 13));

        first.setFont(new Font("Arial", Font.BOLD, 14));
        first.setSize(50, 30);
        first.setBackground(Color.GRAY);
        first.setBorder(new LineBorder(Color.WHITE, 2, true));
        first.setForeground(Color.WHITE);

        last.setFont(new Font("Arial", Font.BOLD, 14));
        last.setSize(50, 30);
        last.setBackground(Color.GRAY);
        last.setBorder(new LineBorder(Color.WHITE, 2, true));
        last.setForeground(Color.WHITE);

        constraints.weightx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridx = 0;

        add_removeKeyboard.add(first_lastDisplay, constraints);
        constraints.gridwidth = 1;

        constraints.weightx = 2;
        constraints.weighty = 2;

        constraints.gridy = 3;
        constraints.gridx = 0;
        add_removeKeyboard.add(first, constraints);

        constraints.gridwidth = 2;
        constraints.gridy = 3;
        constraints.gridx = 1;
        add_removeKeyboard.add(last, constraints);


        f.add("East", add_removeKeyboard);
        f.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        f.pack();
    }


    public void addActions() {
        addFirst.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                list.addFirst(Integer.parseInt(add_removeDisplay.getText()));
                add_removeDisplay.setText("");
                tf.setText(String.valueOf(list));
            }
        });

        addLast.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            list.addLast(Integer.parseInt(add_removeDisplay.getText()));
            System.out.println(Integer.parseInt(add_removeDisplay.getText()));
            add_removeDisplay.setText("");
            tf.setText(String.valueOf(list));
        }

    });
        removeFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                list.removeFirst();
                tf.setText(String.valueOf(list));
            }
        });
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                first_lastDisplay.setText(String.valueOf(list.first()));
            }
        });
        last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                first_lastDisplay.setText(String.valueOf(list.last()));
            }
        });
}
    public static void main(String[] args) {
        new SinglyLinkedListTester();
        /*SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        list1.addFirst(100);
        list1.addLast(200);
        list1.addLast(300);
        System.out.println(list1);
        list1.removeFirst();
        System.out.println(list1);
        System.out.println(list1.first());
        System.out.println(list1.last());*/
    }
}
