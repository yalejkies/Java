import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentYearGUI extends JFrame implements ActionListener {

    JTextField nameField, ageField;
    JComboBox<String> yearBox;
    JButton submitButton;
    JLabel resultLabel;

    public StudentYearGUI() {
        setTitle("Student Year Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // 🌟 Background color (YELLOW THEME)
        getContentPane().setBackground(new Color(255, 242, 153)); // soft yellow

        // Name
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);
        add(nameField);

        // Age
        JLabel ageLabel = new JLabel("Enter Age:");
        ageLabel.setBounds(30, 70, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 70, 200, 25);
        add(ageField);

        // Year
        JLabel yearLabel = new JLabel("Select Year:");
        yearLabel.setBounds(30, 110, 100, 25);
        add(yearLabel);

        String[] years = {"A - 1st Year", "B - 2nd Year", "C - 3rd Year", "D - 4th Year"};
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(150, 110, 200, 25);
        add(yearBox);

        // Button (yellow style)
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 150, 100, 30);
        submitButton.setBackground(new Color(255, 204, 0)); // golden yellow
        submitButton.setForeground(Color.BLACK);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(this);
        add(submitButton);

        // Result text
        resultLabel = new JLabel("");
        resultLabel.setBounds(30, 200, 350, 25);
        resultLabel.setForeground(Color.BLACK);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String ageText = ageField.getText();

        if (name.isEmpty() || ageText.isEmpty()) {
            resultLabel.setText("Please fill in all fields.");
            return;
        }

        int age;

        try {
            age = Integer.parseInt(ageText);
        } catch (Exception ex) {
            resultLabel.setText("Age must be a number.");
            return;
        }

        String choice = yearBox.getSelectedItem().toString();
        String year = "";

        switch (choice.charAt(0)) {
            case 'A': year = "1st year"; break;
            case 'B': year = "2nd year"; break;
            case 'C': year = "3rd year"; break;
            case 'D': year = "4th year"; break;
        }

        resultLabel.setText("Hello " + name + ", age " + age + ", you are " + year);
    }

    public static void main(String[] args) {
        new StudentYearGUI();
    }
}