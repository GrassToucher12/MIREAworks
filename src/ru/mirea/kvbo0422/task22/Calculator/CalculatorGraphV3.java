package ru.mirea.kvbo0422.task22.Calculator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorGraphV3 {
    JFrame f;
    JTextField tf = new JTextField();
    JButton[] b = new JButton[24];
    JTextArea display = new JTextArea(40, 10);
    JScrollPane scroll = new JScrollPane(display);
    JButton delButton = new JButton("Clear calculations history");
    String[] button_arr = new String[]
            {       "C", "<", "^", "!",
                    "(", ")", "\u03c0", "/",
                    "7", "8", "9", "*",
                    "4", "5", "6", "-",
                    "1", "2", "3", "+",
                    "0", "00", ".", "="};
    public String s = "";
    public  String prevOp = "*";
    CalculatorGraphV3(){
        prepareGUI();
        addTextField();
        addButtons();
        addDisplayScroll();
        addActions();
    }
    public void prepareGUI(){
        //Frame
        f = new JFrame();
        f.setBackground(Color.BLACK);
        f.setTitle("Calculator 0.3v");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setResizable(false);
        f.setVisible(true);
        //try //add icon
        //{
        //f.setIconImage(ImageIO.read(new FileInputStream("C:\\Users\\PC\\IdeaProjects\\MIREAworks\\src\\ru\\mirea\\kvbo0422\\Calculator\\icon.png")));
       // }catch(Exception e){}
    }
    public void addTextField(){
        //TextField
        tf = new JTextField(20);
        tf.setBounds(25,20,350,100);
        tf.setFont(new Font("Arial", Font.BOLD, 32));
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setBorder(new LineBorder(Color.GRAY, 5, true));
        tf.setBackground(new Color(137,158,139));
        f.add("North", tf);
    }
    public void addButtons(){
        //Buttons
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(6,4,15,13));
        for (int i=0; i<24; i++){
            b[i] = new JButton(button_arr[i]);
            b[i].setFont(new Font("Arial", Font.BOLD, 26));
            b[i].setSize(70,50);
            keyboard.add(b[i]);
        }
        //Add colors
        b[0].setBackground(new Color(218, 116, 44));
        b[1].setBackground(new Color(218, 116, 44));
        b[2].setBackground(Color.BLACK);
        b[3].setBackground(Color.BLACK);

        b[4].setBackground(Color.BLACK);
        b[5].setBackground(Color.BLACK);
        b[6].setBackground(Color.BLACK);
        b[7].setBackground(Color.BLACK);

        b[8].setBackground(Color.GRAY);
        b[9].setBackground(Color.GRAY);
        b[10].setBackground(Color.GRAY);
        b[11].setBackground(Color.BLACK);

        b[12].setBackground(Color.GRAY);
        b[13].setBackground(Color.GRAY);
        b[14].setBackground(Color.GRAY);
        b[15].setBackground(Color.BLACK);

        b[16].setBackground(Color.GRAY);
        b[17].setBackground(Color.GRAY);
        b[18].setBackground(Color.GRAY);
        b[19].setBackground(Color.BLACK);

        b[20].setBackground(Color.GRAY);
        b[21].setBackground(Color.GRAY);
        b[22].setBackground(Color.GRAY);
        b[23].setBackground(Color.BLACK);

        for (int i=0; i<24; i++){
            b[i].setBorder(new LineBorder(Color.WHITE, 2, true));
            b[i].setForeground(Color.WHITE);
        }
        keyboard.setBackground(Color.BLACK);
        f.add("Center", keyboard);
        f.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        f.pack();
    }
    public void addDisplayScroll(){
        display.setEditable(false);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        display.setBorder(new LineBorder(Color.GRAY, 3, true));
        display.setFont(new Font("Arial", Font.BOLD, 14));
        display.setBorder ( new TitledBorder ( new EtchedBorder (), "Calculations history" ) );
        display.setForeground(Color.BLACK);
        display.setBackground(new Color(249, 182, 75));
        delButton.setFont(new Font("Arial", Font.BOLD, 14));
        delButton.setForeground(Color.WHITE);
        delButton.setBackground(new Color(218, 116, 44));
        delButton.setBorder(new LineBorder(Color.WHITE, 2, true));

        f.add("East", scroll);
        f.add("South", delButton);
    }
    public void addActions(){
        for (int i=0; i<24; i++){
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {//clear TextField
                    for (int i=0; i<24; i++) {
                        if (e.getSource() == b[0]) {
                            s = "";
                            tf.setText("");
                            prevOp = "*";
                            break;
                        }
                        if ((e.getSource() == b[1]) && (!s.isEmpty())) {//delete one symbol
                            s = s.substring(0, s.length() - 1);
                            if (!s.isEmpty()) {
                                prevOp = s.substring(s.length() - 1, s.length());
                            } else {
                                prevOp = "*";
                            }
                            tf.setText(s);
                            break;
                        }
                        if (e.getSource() == b[23]) {//do calculations if "=" is pressed
                            display.append(s);
                            display.append(" = \n" + "\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022");
                            doCalculations();
                            display.append("\nans: " + tf.getText() + "\n\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\n");
                            break;
                        }
                        if ((e.getSource() == b[i]) &&
                                !((((Objects.equals(prevOp, "^")) ||
                                        (Objects.equals(prevOp, "/")) ||
                                        (Objects.equals(prevOp, "*")) ||
                                        (Objects.equals(prevOp, "-")) ||
                                        (Objects.equals(prevOp, "+")) ||
                                        (Objects.equals(prevOp, "."))) &&
                                        ((i == 2)
                                                || (i == 7)
                                                || (i == 5)
                                                || (i == 3)
                                                || (i == 11)
                                                || (i == 15)
                                                || (i == 19)
                                                || (i == 22)))
                                        || ((Objects.equals(prevOp, "\u03c0")) && ((i == 6) || (i == 22)))
                                        || ((Objects.equals(prevOp, ")")) && ((i == 5) || (i == 4) || (i == 6) || (i == 22) || (i == 8) || (i == 9) || (i == 10) || (i == 12) || (i == 13) || (i == 14) || (i == 16) || (i == 17) || (i == 18) || (i == 20) || (i == 21)))
                                        || ((Objects.equals(prevOp, "(")) && ((i == 4) || (i == 5) || (i == 19) || (i == 11) || (i == 7) || (i == 3) || (i == 2) || (i == 22)))
                                        || ((Objects.equals(prevOp, "!")) && ((i == 3) || (i == 22)))
                                        || (((Objects.equals(prevOp, "0"))
                                        || (Objects.equals(prevOp, "1"))
                                        || (Objects.equals(prevOp, "2"))
                                        || (Objects.equals(prevOp, "3"))
                                        || (Objects.equals(prevOp, "4"))
                                        || (Objects.equals(prevOp, "5"))
                                        || (Objects.equals(prevOp, "6"))
                                        || (Objects.equals(prevOp, "7"))
                                        || (Objects.equals(prevOp, "8"))
                                        || (Objects.equals(prevOp, "9"))
                                        || (Objects.equals(prevOp, "00")))
                                        && (i == 4))
                                )) {
                            if (!(((Objects.equals(prevOp, "9")) || (Objects.equals(prevOp, "8")) || (Objects.equals(prevOp, "7")) || (Objects.equals(prevOp, "6")) ||
                                    (Objects.equals(prevOp, "5")) || (Objects.equals(prevOp, "4")) || (Objects.equals(prevOp, "3")) || (Objects.equals(prevOp, "2")) ||
                                    (Objects.equals(prevOp, "1")) || (Objects.equals(prevOp, "0")) || (Objects.equals(prevOp, "00"))) && (i == 6))) {//add symbols in TextField
                                s = s + button_arr[i];
                                prevOp = button_arr[i];
                                if (s.length() > 16) {
                                    s = "";
                                }
                            }
                            tf.setText(s);
                        }
                    }
                }
            });
        }
        delButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            display.setText("");
            }

        });
    }
    public void doCalculations() {
        boolean state = true;
        while (state) {
            if (!isValidBrackets(s)){
                this.s = "";
                tf.setText("Error");
                state = false;
                continue;
            }
            for (int i = 1; i < s.length(); i++){
                if ((s.charAt(i-1) == '(' )&&(s.charAt(i) == '-' )){
                    s = s.substring(0, i)+ "0" + s.substring(i);
                }
            }
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '!' ){
                    s = s.substring(0, i+1)+ "0" + s.substring(i+1);
                }
            }
            Pattern pAct = Pattern.compile("[+\\-*/!^()]");
            String[] numbers = this.s.split("[+\\-*/!^()]");
            Matcher act = pAct.matcher(this.s);

            int length = numbers.length;

            String[] operations = new String[length];

            int k = 0;
                while (act.find()) {
                    operations[k] = act.group();
                    k++;
                }

            ArrayList<String> numList = new ArrayList<>(Arrays.asList(numbers));
            ArrayList<String> opList = new ArrayList<>(Arrays.asList(operations));

            for (int i = numList.size()-1; i >= 0; i--) {
                if (Objects.equals(numList.get(i), ""))
                    numList.remove(i);
            }

            for (int i = opList.size()-1; i >= 0; i--) {
                if (Objects.equals(opList.get(i), null))
                    opList.remove(i);
            }

            if ((numList.isEmpty())&&(opList.isEmpty()))
            {
                this.s = "";
                tf.setText("");
                state = false;
                continue;
            }
            if ((numList.size() == 1)&&(opList.isEmpty()))
            {
                this.s = "";
                tf.setText(numList.get(0));
                state = false;
                continue;
            }
            s = s.replaceAll("π","3.1415926535");
            try {
                Calc calculation = new Calc();
                tf.setText(String.valueOf(calculation.calculate(s)));
            }
            catch (RuntimeException e){
                this.s = "";
                tf.setText("Error");
                state = false;
                continue;
            }

            this.s = "";
            state = false;

        }
    }
    private static boolean isValidBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c)) {

                stack.push(c);
            } else if (brackets.containsKey(c)) {

                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}