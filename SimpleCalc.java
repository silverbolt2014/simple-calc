import javax.swing.*;
import java.awt.*; // layout managers
import java.awt.event.*; // ActionListener interface

public class SimpleCalc {

    JFrame frame;
    JTextField num1TextField;
    JTextField num2TextField;
    JTextField resultsTextField;
    JButton goButton;
    JButton resetButton;
    JComboBox<String> selectOperationComboBox;

    public static void main(String[] args) {
        SimpleCalc simpleCalcGui = new SimpleCalc();
        simpleCalcGui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("Number 1");
        JLabel num2Label = new JLabel("Number 2");
        JLabel resultsLabel = new JLabel("Results");

        num1TextField = new JTextField();
        num2TextField = new JTextField();
        resultsTextField = new JTextField();
        resultsTextField.setEditable(false);
        
        String[] operationStrings = {"Add", "Minus", "Multiply", "Divide"};
        selectOperationComboBox = new JComboBox<String>(operationStrings);
        
        goButton = new JButton("GO!");
        goButton.addActionListener( new GoButtonActionListener() );

        resetButton = new JButton("Reset");
        resetButton.addActionListener( new ResetButtonActionListener() );

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainPanel.add(num1Label);
        mainPanel.add(num1TextField);

        mainPanel.add(selectOperationComboBox);
        
        mainPanel.add(num2Label);
        mainPanel.add(num2TextField);
        
        mainPanel.add(resultsLabel);
        mainPanel.add(resultsTextField);

        mainPanel.add(goButton);
        mainPanel.add(resetButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);        
    }
    
    public class GoButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //System.out.println("this is go button actionlistener event");

            String num1String = "-1";
            String num2String = "-1";

            try {
                num1String = num1TextField.getText();
                num2String = num2TextField.getText();
                System.out.println("num1String = " + num1String);
                System.out.println("num2String = " + num2String);
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }


            int num1;
            int num2;
            try {
                num1 = Integer.parseInt(num1String);
                num2 = Integer.parseInt(num2String);
                String operationToPerform = (String) selectOperationComboBox.getSelectedItem();
                performCalculation(num1, num2, operationToPerform);
            } catch (NumberFormatException e) {
                System.out.println("There was a problem with one or more number inputted by the user");
            }
        }
    }

    void performCalculation(double n1, double n2, String operation) {
        double result = 0;
        switch (operation.toLowerCase()) {
             case "add":
                System.out.println("Add Selected");
                result = n1 + n2;
                break;
            case "minus":
                System.out.println("Minus Selected");
                break;
            case "multiply":
                System.out.println("Multiply Selected");
                break;
            case "divide":
                System.out.println("Divide Selected");
                break;
        }

        resultsTextField.setText(result + "");
    }

    public class ResetButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("this is reset button actionlistener event");

        }
    }    
}