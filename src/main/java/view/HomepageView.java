package java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.interface_adapter.load_homepage.LoadHomepageController;
import java.interface_adapter.load_homepage.LoadHomepageViewModel;

public class HomepageView {

    private final String viewName = "homepage";
    private final LoadHomepageViewModel loadHomepageViewModel;
    private final LoadHomepageController loadHomepageController;

    private final JButton createExperiment;
    private final JButton profile;
    private final JButton logOut;

    // do the tables belong here?
    private JTable experiments;
    private JTable myExperiments;

    public HomepageView(LoadHomepageController controller, LoadHomepageViewModel loadHomepageViewModel){
        this.loadHomepageController = controller;
        this.loadHomepageViewModel = loadHomepageViewModel;
        // add line about adding property change listener to viewmodel, not 100% sure what its for
        loadHomepageViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(loadHomepageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        // add some set alignment thing

        // potentially create panels of title + table for both experiments and my experiment
        // idk where to add all the deets of that

        final JPanel myExperimentsPanel = new JPanel();
        // add title(might be included in columns)
        // create experiment button
        createExperiment = new JButton(LoadHomepageViewModel.CREATE_EXPERIMENT_BUTTON_LABEL);
        profile = new JButton(LoadHomepageViewModel.PROFILE_BUTTON_LABEL);
        logOut = new JButton(LoadHomepageViewModel.LOGOUT_BUTTON_LABEL);
        myExperimentsPanel.add(createExperiment);
        // add table
        myExperiments = new JTable(loadHomepageViewModel.myExperimentsData, loadHomepageViewModel.myExperimentsColumns);
        myExperimentsPanel.add(myExperiments);
        final JPanel experimentsPanel = new JPanel();
        // add title(might be included in column)
        // add table
        experiments = new JTable(loadHomepageViewModel.experimentsData, loadHomepageViewModel.experimentsColumns);
        experimentsPanel.add(experiments);

        createExperiment.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {loadHomepageController.switchToCreateExperimentView();}
                }
        );

        profile.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {loadHomepageController.switchToViewProfileView();}
                }
        );
        // do action listener stuff for logout button


        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        // 2. Execute the logout Controller.
                        final LoggedInState currentState = loggedInViewModel.getState();
                        this.logoutController.execute(currentState.getUsername());
                    }
                }
        );






    }

}
