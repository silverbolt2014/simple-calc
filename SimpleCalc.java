import javax.swing.*;
import java.awt.*; // layout managers
import java.awt.event.*; // ActionListener interface

public class SimpleCalc {

    JFrame frame;
    JTextField num1TextField;
    JTextField num2TextField;

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

        JTextField num1TextField = new JTextField();
        JTextField num2TextField = new JTextField();
        JTextField resultsTextField = new JTextField();
        resultsTextField.setEditable(false);
        
        String[] operationStrings = {"Add", "Minus", "Multiply", "Divide"};
        JComboBox<String> selectOperationComboBox = new JComboBox<String>(operationStrings);
        
        JButton goButton = new JButton("GO!");
        goButton.addActionListener( new GoButtonActionListener() );

        JButton resetButton = new JButton("Reset");
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
        public void actionPerformed(ActionEvent e) {
            System.out.println("this is go button actionlistener event");

        }
    }

    public class ResetButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("this is reset button actionlistener event");

        }
    }    
}
