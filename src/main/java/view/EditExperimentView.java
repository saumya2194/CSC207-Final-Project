package view;

import interface_adapter.EditStudy.EditStudyController;
import interface_adapter.EditStudy.EditStudyState;
import interface_adapter.EditStudy.EditStudyViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditExperimentView extends JPanel implements PropertyChangeListener {

    private final String viewName = "edit study";

    private final EditStudyViewModel editStudyViewModel;
    private final JTextField titleInputField = new JTextField(30);
    private final JTextArea detailsInputField = new JTextArea(20,20);
    private final JTextField IDInputField = new JTextField(20);
    private EditStudyController editStudyController;

    private final JButton editStudy;
    private final JButton cancel;

    public EditExperimentView(EditStudyViewModel editStudyViewModel) {
        this.editStudyViewModel = editStudyViewModel;
        editStudyViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(EditStudyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final LabelTextPanel studyTitleInfo = new LabelTextPanel(
                new JLabel(EditStudyViewModel.STUDY_TITLE_LABEL), titleInputField);
        final LabelTextPanel idInfo = new LabelTextPanel(
                new JLabel(EditStudyViewModel.ID_LABEL), IDInputField);
        final LabelTextPanel detailsInfo = new LabelTextPanel(
                new JLabel(EditStudyViewModel.DETAILS_LABEL), detailsInputField);
        final JPanel buttons = new JPanel();
        editStudy = new JButton(EditStudyViewModel.EDIT_STUDY_BUTTON_LABEL);
        buttons.add(editStudy);
        cancel = new JButton(EditStudyViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        editStudy.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(editStudy)) {
                            final EditStudyState currentState = editStudyViewModel.getState();
                            System.out.println(currentState);
                            editStudyController.execute(
                                    currentState.getTitle(),
                                    currentState.getDetails(),
                                    currentState.getUser(),
                                    currentState.getID()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        editStudyController.switchToHomepageView();
                    }
                }
        );

        addIDListener();
        addStudyTitleListener();
        addDetailsListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(idInfo);
        this.add(studyTitleInfo);
        this.add(detailsInfo);
        this.add(buttons);
    }
    private void addIDListener() {
        titleInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final EditStudyState currentState = editStudyViewModel.getState();
                currentState.setID(IDInputField.getText());
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

    private void addStudyTitleListener() {
        titleInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final EditStudyState currentState = editStudyViewModel.getState();
                currentState.setTitle(titleInputField.getText());
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

    private void addDetailsListener() {
        detailsInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final EditStudyState currentState = editStudyViewModel.getState();
                currentState.setDetails(detailsInputField.getText());
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
    public void propertyChange(PropertyChangeEvent evt) {
        final EditStudyState state = (EditStudyState) evt.getNewValue();
        if (state.getDetailsError() != null) {
            JOptionPane.showMessageDialog(this, state.getDetailsError());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setEditStudyController(EditStudyController controller) {
        this.editStudyController = controller;
    }

}
