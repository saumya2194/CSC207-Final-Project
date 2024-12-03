package view;

import interface_adapter.EditStudy.EditStudyController;
import interface_adapter.enter_id.EnterIDState;
import interface_adapter.enter_id.EnterIDViewModel;
import interface_adapter.view_experiment.ViewExperimentController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterIdView extends JPanel implements ActionListener {

    private final String viewName = "enter id";
    private final EnterIDViewModel enterIdViewModel;

    private final JTextField enterIdInputField = new JTextField(30);
    private ViewExperimentController viewExperimentController;

    private final JButton enterIdButton;
    private final JButton cancelButton;

    public EnterIdView(EnterIDViewModel enterIdViewModel) {
        this.enterIdViewModel = enterIdViewModel;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel enterIdLabel = new JLabel(EnterIDViewModel.ID_LABEL);
        enterIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        final LabelTextPanel IDInfo = new LabelTextPanel(new JLabel(EnterIDViewModel.ID_LABEL), enterIdInputField);
        final JPanel buttons = new JPanel();
        enterIdButton = new JButton(EnterIDViewModel.ID_CONFIRM_BUTTON_LABEL);
        cancelButton = new JButton(EnterIDViewModel.ID_CANCEL_BUTTON_LABEL);
        buttons.add(enterIdButton);
        buttons.add(cancelButton);

        enterIdButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(enterIdButton)) {
                            final EnterIDState currentState = enterIdViewModel.getState();
                            System.out.println(currentState);
                            viewExperimentController.execute(currentState.getId());
                        }
                    }
                }
        );
        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        viewExperimentController.switchToHomepageView();
                    }
                }
        );
        addenterIdListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(enterIdLabel);
        this.add(IDInfo);
        this.add(buttons);
    }

    private void addenterIdListener() {
        enterIdInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper() {
                final EnterIDState currentState = enterIdViewModel.getState();
                currentState.setId(enterIdInputField.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }
        @Override
        public void actionPerformed (ActionEvent e) {System.out.println("Click " + e.getActionCommand());}

    public String getViewName() {
        return viewName;
    }

    public void setViewExperimentController(ViewExperimentController controller) {
        this.viewExperimentController = controller;
    }
    }

