package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;
import interface_adapter.load_homepage.LoadHomepageController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.signup.SignupController;

/**
 * A simple view to display a success message after logging in.
 */
public class LoggedInView extends JPanel implements ActionListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JButton goToHomepageButton;
    private  LoadHomepageController homepageController;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;

        // Set up the layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the success message
        JLabel successMessage = new JLabel("Hooray! You logged in.");
        successMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        goToHomepageButton = new JButton("Go to homepage");
        // Add the "Go to Homepage" button
        goToHomepageButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(goToHomepageButton)) {
                            final LoggedInState currentState = loggedInViewModel.getState();

                            homepageController.execute(
                                    currentState.getUsername()
                            );
                        }
                    }
                }
        );
        //TODO: BELOW COMMENTEC OUT FOR NOW
//        goToHomepageButton = new JButton("Go to Homepage");
//        goToHomepageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//        goToHomepageButton.addActionListener(this);

        // Add components to the panel
        this.add(successMessage);
        this.add(goToHomepageButton);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
//        TODO: DELETE COMMENTED OUT LINES BELOW
//        if (evt.getSource().equals(goToHomepageButton)) {
//            final LoggedInState loggedInState = loggedInViewModel.getState();
//            String user = loggedInState.getUsername();
//            // Delegate control to the HomepageController
//            homepageController.execute(user);
//        }
    }

    //public void setLoadHomepageController(LoadHomepageController homepageController) {
    //   this.loadHomepageController = homepageController;
    //}

    public String getViewName() {
        return viewName;
    }

    public void setLoadHomepageController(LoadHomepageController controller) {
        this.homepageController = controller; }
}