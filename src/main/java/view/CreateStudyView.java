package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.createstudy.CreateStudyController;
import interface_adapter.createstudy.CreateStudyState;
import interface_adapter.createstudy.CreateStudyViewModel;

/**
 * The View for the Create Study Use Case.
 */
public class CreateStudyView extends JPanel implements PropertyChangeListener {
    private final String viewName = "create study";

    private final CreateStudyViewModel createStudyViewModel;
    private final JTextField titleInputField = new JTextField(30);
    private final JTextField detailsInputField = new JPasswordField(100);
    private CreateStudyController createStudyController;

    private final JButton createStudy;
    private final JButton cancel;

    public CreateStudyView(CreateStudyViewModel createStudyViewModel) {
        this.createStudyViewModel = createStudyViewModel;
        createStudyViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(CreateStudyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final LabelTextPanel studyTitleInfo = new LabelTextPanel(
                new JLabel(CreateStudyViewModel.STUDY_TITLE_LABEL), titleInputField);
        final LabelTextPanel detailsInfo = new LabelTextPanel(
                new JLabel(CreateStudyViewModel.PASSWORD_LABEL), detailsInputField);
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
                createStudyViewModel.setState(currentState);
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
                final CreateStudyState currentState = createStudyViewModel.getState();
                currentState.setDetails(detailsInputField.getText());
                createStudyViewModel.setState(currentState);
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
        this.createStudyController = controller;
    }
}

