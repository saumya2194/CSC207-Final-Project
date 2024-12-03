package view;

import interface_adapter.EditStudy.EditStudyViewModel;
import interface_adapter.createstudy.CreateStudyController;
import interface_adapter.createstudy.CreateStudyState;
import interface_adapter.createstudy.CreateStudyViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

public class EditExperimentView extends JPanel implements ActionListener {

    private final String viewName = "edit study";

    private final EditExperimentView editStudyViewModel;
    private final JTextField titleInputField = new JTextField(30);
    private final JTextArea detailsInputField = new JTextArea(20,20);
    private final JTextField IDInputField = new JTextField(20);
    private CreateStudyController editStudyController;

    private final JButton createStudy;
    private final JButton cancel;

    public EditExperimentView(EditStudyViewModel editStudyViewModel) {
        this.editStudyViewModel = editStudyViewModel;
        editStudyViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(CreateStudyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final LabelTextPanel studyTitleInfo = new LabelTextPanel(
                new JLabel(CreateStudyViewModel.STUDY_TITLE_LABEL), titleInputField);
        final LabelTextPanel detailsInfo = new LabelTextPanel(
                new JLabel(CreateStudyViewModel.DETAILS_LABEL), detailsInputField);
        final JPanel buttons = new JPanel();
        createStudy = new JButton(CreateStudyViewModel.CREATE_STUDY_BUTTON_LABEL);
        buttons.add(createStudy);
        cancel = new JButton(CreateStudyViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        createStudy.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createStudy)) {
                            final CreateStudyState currentState = createStudyViewModel.getState();

                            createStudyController.execute(
                                    currentState.getTitle(),
                                    currentState.getDetails(),
                                    currentState.getUser()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        createStudyController.switchToHomepageView();
                    }
                }
        );

        addStudyTitleListener();
        addDetailsListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(studyTitleInfo);
        this.add(detailsInfo);
        this.add(buttons);
    }

    private void addStudyTitleListener() {
        titleInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final CreateStudyState currentState = createStudyViewModel.getState();
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
                final CreateStudyState currentState = editStudyViewModel.getState();
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
        final CreateStudyState state = (CreateStudyState) evt.getNewValue();
        if (state.getDetailsError() != null) {
            JOptionPane.showMessageDialog(this, state.getDetailsError());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setCreateStudyController(CreateStudyController controller) {
        this.editStudyController = controller;
    }
}
