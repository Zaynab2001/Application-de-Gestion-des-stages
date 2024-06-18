package stg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculatrice extends JFrame {

    private JTextField textField;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonEquals;
    private JButton buttonClear;

    private double firstNumber;
    private String operator;

    public Calculatrice() {
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);
        contentPane.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        button7 = createButton("7");
        button8 = createButton("8");
        button9 = createButton("9");
        buttonDivide = createButton("/");
        button4 = createButton("4");
        button5 = createButton("5");
        button6 = createButton("6");
        buttonMultiply = createButton("*");
        button1 = createButton("1");
        button2 = createButton("2");
        button3 = createButton("3");
        buttonMinus = createButton("-");
        button0 = createButton("0");
        buttonClear = createButton("C");
        buttonEquals = createButton("=");
        buttonPlus = createButton("+");

        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button0);
        buttonPanel.add(buttonClear);
        buttonPanel.add(buttonEquals);
        buttonPanel.add(buttonPlus);

        contentPane.add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(final String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(label);
            }
        });
        return button;
    }

    private void handleButtonClick(String label) {
        if (label.equals("C")) {
            clear();
        } else if (label.matches("[0-9]")) {
            appendNumber(label);
        } else if (label.matches("[-+*/]")) {
            setOperator(label);
        } else if (label.equals("=")) {
            calculate();
        }
    }

    private void clear() {
        textField.setText("");
        firstNumber = 0;
        operator = null;
    }

    private void appendNumber(String number) {
        textField.setText(textField.getText() + number);
    }

    private void setOperator(String op) {
        firstNumber = Double.parseDouble(textField.getText());
        operator = op;
        textField.setText("");
    }

    private void calculate() {
        double secondNumber = Double.parseDouble(textField.getText());
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    textField.setText("Error");
                    return;
                }
                break;
        }
        textField.setText(Double.toString(result));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculatrice frame = new Calculatrice();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
