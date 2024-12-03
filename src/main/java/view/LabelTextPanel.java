package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * A panel containing a label and a text field.
 */
class LabelTextPanel extends JPanel {
    LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }

    LabelTextPanel(JLabel label, JTextArea textArea) {
        this.add(label);
        this.add(textArea);
    }
}
