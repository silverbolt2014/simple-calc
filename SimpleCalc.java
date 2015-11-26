import javax.swing.*;
import java.awt.*; // layout managers
//import java.awt.event.*; // ActionListener interface

public class SimpleCalc {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("Number 1");
        JLabel num2Label = new JLabel("Number 2");
        JLabel resultsLabel = new JLabel("Results");

        JTextField num1TextField = new JTextField();
        JTextField num2TextField = new JTextField();
        JTextField resultsTextField = new JTextField();
        
        //String[] operationStrings = {"Add", "Minus", "Multiply", "Divide"};
        //JComboBox<String> selectOperationComboBox = new JComboBox<String>(operationStrings);
        
        //selectOperationComboBox.addActionListener( new OperationComboBoxListener() );
        
        //selectOperation.setSelectedIndex(-1);

        JButton resetButton = new JButton("Reset");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainPanel.add(num1Label);
        mainPanel.add(num1TextField);
        
        mainPanel.add(num2Label);
        mainPanel.add(num2TextField);
        
        mainPanel.add(resultsLabel);
        mainPanel.add(resultsTextField);
        
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
