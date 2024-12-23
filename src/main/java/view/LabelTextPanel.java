package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class LabelTextPanel extends JPanel {
    LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }

    public LabelTextPanel(JLabel label, JTextArea textArea) {
        this.add(label);
        this.add(textArea);
    }
}
