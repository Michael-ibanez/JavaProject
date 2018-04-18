package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIComponent extends JFrame {
    JTextField tfDisplay;  // to display the number entered
    JTextField tfFrom;  // to display the number entered
    JTextField tfTo;  // to display the number entered

    /** Constructor to setup the GUI components */
    public GUIComponent() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        tfDisplay = new JTextField(10);
        tfDisplay.setEditable(false);

        tfTo = new JTextField(10);
        tfTo.setEditable(true);

        tfFrom = new JTextField(10);
        tfFrom.setEditable(true);

        cp.add(tfDisplay);
        cp.add(tfTo);
        cp.add(tfFrom);


        JButton btn = new JButton("Input");
        cp.add(btn);
        btn.addActionListener(new ActionListener() {

            // Error does nothing
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = false;  // for input validation
                int numberIn;
                String inputStr = JOptionPane.showInputDialog("Enter a number [1-9]: ");
                do {
                    try {
                        numberIn = Integer.parseInt(inputStr);
                    } catch (NumberFormatException ex) {
                        numberIn = -1;  // input triggered NumberFormatException, set to invalid
                    }
                    if (numberIn < 1 || numberIn > 9) {
                        inputStr = JOptionPane.showInputDialog("Invalid numner! Enter a number [1-9]: ");
                    } else {
                        JOptionPane.showMessageDialog(null, "You have entered " + numberIn);
                        validInput = true;
                    }
                } while (!validInput); // repeat if input is not valid
                tfDisplay.setText(numberIn + "");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 100);
        setTitle("Test Input Dialog");
        setVisible(true);
    }
}
