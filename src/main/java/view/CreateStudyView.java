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
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;

/**
 * The View for the Create Study Use Case.
 */
public class CreateStudyView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "create study";

    private final CreateStudyViewModel createStudyViewModel;
    private final JTextField titleInputField = new JTextField(30);
    private final JPasswordField detailsInputField = new JPasswordField(100);
    private CreateStudyController createStudyController;

    private final JButton createStudy;
    private final JButton cancel;

    public CreateStudyView(CreateStudyViewModel createStudyViewModel) {
        this.createStudyViewModel = createStudyViewModel;
        createStudyViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(CreateStudyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(CreateStudyViewModel.STUDY_TITLE_LABEL), titleInputField);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
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
                            final CreateStudyState currentState = CreateStudyViewModel.getState();

                            createStudyController.execute(
                                    currentState.getTitle(),
                                    currentState.getDetails(),
                                    currentState.getUser()
                            );
                        }
                    }
                }
        );

        toLogin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        signupController.switchToLoginView();
                    }
                }
        );

        cancel.addActionListener(this);

        addTitleListener();
        addDetailsListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(titleInfo);
        this.add(detailsInfo);
        this.add(buttons);
    }

    private void addUsernameListener() {
        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                signupViewModel.setState(currentState);
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

    private void addPasswordListener() {
        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                signupViewModel.setState(currentState);
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
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSignupController(SignupController controller) {
        this.signupController = controller;
    }
}

