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
    Font defaultFont = new Font("Serif", Font.BOLD, 20);

    public static void main(String[] args) {
        SimpleCalc simpleCalcGui = new SimpleCalc();
        simpleCalcGui.initialize();
    }

    /**
    * This method mainly sets up the gui components.
    */
    public void initialize(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("Number 1");
        num1Label.setFont(defaultFont);
        
        JLabel num2Label = new JLabel("Number 2");
        num2Label.setFont(defaultFont);
        
        JLabel resultsLabel = new JLabel("Results");
        resultsLabel.setFont(defaultFont);

        num1TextField = new JTextField();
        num1TextField.setFont(defaultFont);
        num1TextField.setHorizontalAlignment(JTextField.CENTER);

        num2TextField = new JTextField();
        num2TextField.setFont(defaultFont);
        num2TextField.setHorizontalAlignment(JTextField.CENTER);

        resultsTextField = new JTextField();
        resultsTextField.setFont(defaultFont);
        resultsTextField.setEditable(false);
        resultsTextField.setHorizontalAlignment(JTextField.CENTER);
        
        String[] operationStrings = {"Add", "Minus", "Multiply", "Divide"};
        selectOperationComboBox = new JComboBox<String>(operationStrings);
        selectOperationComboBox.setFont(defaultFont);
        ((JLabel)selectOperationComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        goButton = new JButton("GO!");
        goButton.addActionListener( new GoButtonActionListener() );
        goButton.setFont(defaultFont);
        //goButton.setHorizontalAlignment(SwingConstants.CENTER);

        resetButton = new JButton("Reset");
        resetButton.addActionListener( new ResetButtonActionListener() );
        resetButton.setFont(defaultFont);
        //resetButton.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        mainPanel.add(num1Label);
        mainPanel.add(num1TextField);

        mainPanel.add(selectOperationComboBox);
        
        mainPanel.add(num2Label);
        mainPanel.add(num2TextField);
        
        mainPanel.add(resultsLabel);
        mainPanel.add(resultsTextField);

        mainPanel.add(buttonPanel);

        buttonPanel.add(goButton);
        buttonPanel.add(resetButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(300, 500);// w x h
        frame.setVisible(true);        
    }
    
    public class GoButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //System.out.println("this is go button actionlistener event");
            String num1String = null;
            String num2String = null;
            boolean canPrepareCalculation = false;
            try {
                num1String = num1TextField.getText();
                num2String = num2TextField.getText();
                canPrepareCalculation = true;
                //System.out.println("num1String = " + num1String);
                //System.out.println("num2String = " + num2String);

            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }

            if (canPrepareCalculation) {
                int num1;
                int num2;
                try {
                    num1 = Integer.parseInt(num1String);
                    num2 = Integer.parseInt(num2String);
                    String operationToPerform = (String) selectOperationComboBox.getSelectedItem();
                    performCalculation(num1, num2, operationToPerform);
                } catch (NumberFormatException e) {
                    System.out.println("There was a problem with the input provided by the user. Please use valid numbers.");
                }
            }
        }
    }

    void performCalculation(double n1, double n2, String operation) {
        double result = Double.NaN;
        switch (operation.toLowerCase()) {
             case "add":
                //System.out.println("Add Selected");
                result = n1 + n2;
                break;
            case "minus":
                //System.out.println("Minus Selected");
                result = n1 - n2;
                break;
            case "multiply":
                //System.out.println("Multiply Selected");
                result = n1 * n2;
                break;
            case "divide":
                //System.out.println("Divide Selected");
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    JLabel errorMessageLabel = new JLabel("Unable to perform operation.  Invalid divisor.");
                    errorMessageLabel.setFont(defaultFont);
                    JOptionPane pane = new  JOptionPane(errorMessageLabel, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
                    JDialog dialog = pane.createDialog(frame, "Error");
                    dialog.setVisible(true);
                }
                break;
            default:
                System.out.println("We should never get here.  Default case statement");
            break;
        }

        resultsTextField.setText(result + "");
    }

    public class ResetButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //System.out.println("this is reset button actionlistener event");
            num1TextField.setText("");
            num2TextField.setText("");
            resultsTextField.setText("");
        }
    }    
}