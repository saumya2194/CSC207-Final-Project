package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.view_profile.EditProfileController;
import interface_adapter.view_profile.ProfileState;
import interface_adapter.view_profile.ProfileViewModel;
import interface_adapter.logout.LogoutController;

/**
 * The View for when the user is logged into the program.
 */
public class ProfileView extends JPanel implements PropertyChangeListener {

    private final String viewName = "profile view";
    private final ProfileViewModel profileViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private EditProfileController editProfileController;
    private LogoutController logoutController;

    private final JLabel username;

    private final JButton logOut;

    private final JTextField passwordInputField = new JTextField(15);
    private final JButton changePassword;

    public ProfileView(ProfileViewModel profileViewModel) {
        this.profileViewModel = profileViewModel;
        this.profileViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        final JPanel buttons = new JPanel();
        logOut = new JButton("Log Out");
        buttons.add(logOut);

        changePassword = new JButton("Change Password");
        buttons.add(changePassword);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final ProfileState currentState = profileViewModel.getState();
                currentState.setPassword(passwordInputField.getText());
                profileViewModel.setState(currentState);
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

        changePassword.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(changePassword)) {
                        final ProfileState currentState = profileViewModel.getState();

                        this.editProfileController.execute(
                                currentState.getUsername(),
                                currentState.getPassword()
                        );
                    }
                }
        );

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        // 2. Execute the logout Controller.
                        final ProfileState currentState = profileViewModel.getState();
                        this.logoutController.execute(currentState.getUsername());
                    }
                }
        );

        this.add(title);
        this.add(usernameInfo);
        this.add(username);

        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final ProfileState state = (ProfileState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final ProfileState state = (ProfileState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setChangePasswordController(EditProfileController editProfileController) {
        this.editProfileController = editProfileController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}