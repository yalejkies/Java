import javax.swing.*;
import java.awt.*;

public class ShoppingCartGUI extends JFrame {

    JTextField itemField, qtyField, priceField;
    JTextArea cartArea;
    double totalCost = 0;

    public ShoppingCartGUI() {
        setTitle("Shopping Cart GUI");
        setSize(300, 320); // SMALL SIZE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(173, 216, 230));
        setLayout(new BorderLayout(5, 5));

        // INPUT PANEL
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 3, 3));
        inputPanel.setBackground(new Color(173, 216, 230));

        itemField = new JTextField();
        qtyField = new JTextField();
        priceField = new JTextField();

        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(itemField);
        inputPanel.add(new JLabel("Qty:"));
        inputPanel.add(qtyField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);

        add(inputPanel, BorderLayout.NORTH);

        // CART AREA (SMALL)
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setBackground(new Color(240, 248, 255));
        cartArea.setForeground(new Color(25, 25, 112));

        add(new JScrollPane(cartArea), BorderLayout.CENTER);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonPanel.setBackground(new Color(173, 216, 230));

        JButton addButton = new JButton("Add");
        JButton totalButton = new JButton("Total");
        JButton clearButton = new JButton("Clear");

        addButton.setBackground(new Color(30, 144, 255));
        addButton.setForeground(Color.WHITE);

        totalButton.setBackground(new Color(70, 130, 180));
        totalButton.setForeground(Color.WHITE);

        clearButton.setBackground(new Color(100, 149, 237));
        clearButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(totalButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ACTIONS
        addButton.addActionListener(e -> {
            try {
                String item = itemField.getText();
                int qty = Integer.parseInt(qtyField.getText());
                double price = Double.parseDouble(priceField.getText());

                double cost = qty * price;
                totalCost += cost;

                cartArea.append(item + " x" + qty + " = " + cost + "\n");

                itemField.setText("");
                qtyField.setText("");
                priceField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        totalButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Total: " + totalCost + " pesos"));

        clearButton.addActionListener(e -> {
            cartArea.setText("");
            totalCost = 0;
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ShoppingCartGUI();
    }
}