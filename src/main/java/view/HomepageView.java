package java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.interface_adapter.load_homepage.LoadHomepageController;
import java.interface_adapter.load_homepage.LoadHomepageState;
import java.interface_adapter.load_homepage.LoadHomepageViewModel;

public class HomepageView {

    private final String viewName = "homepage";
    private final LoadHomepageViewModel loadHomepageViewModel;
    private LoadHomepageController loadHomepageController;

    private final JButton createExperiment;
    private final JButton profile;
    private final JButton logOut;

    // do the tables belong here?
    private JTable experiments = new JTable(new Object[][], loadHomepageViewModel.experimentsColumns);;
    private JTable myExperiments = new JTable(new Object[][], loadHomepageViewModel.myExperimentsColumns);;

    public HomepageView(LoadHomepageController controller, LoadHomepageViewModel loadHomepageViewModel){
        this.loadHomepageViewModel = loadHomepageViewModel;
        // add line about adding property change listener to viewmodel, not 100% sure what its for
        this.loadHomepageViewModel.addPropertyChangeListener(this);

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


        myExperimentsPanel.add(myExperiments);
        final JPanel experimentsPanel = new JPanel();
        // add title(might be included in column)
        // add table
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

        myExperiments.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount == 2){
                    // what to do when double click occurs
                    String data = myExperiments.getValueAt(myExperiments.getSelectedRow(), 0).toString();
                    // I could input the experiment id into the controller of the experiments thing

                }
            }
        });

        experiments.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount == 2){
                    // what to do when double click occurs
                    String data = experiments.getValueAt(experiments.getSelectedRow(), 0).toString();
                    // I could input the experiment id into the controller of the experiments thing
                }
            }
        });

        this.add(title);
        this.add(profile);
        this.add(logOut);
        this.add(experimentsPanel);
        this.add(myExperimentsPanel);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("load homepage")) {
            final LoadHomepageState state = (LoadHomepageState) evt.getNewValue();
            setTables(state);

        }

    }

    private void setTables(LoadHomepageState state) {
        myExperiments = new JTable(state.getMyExperiments(), loadHomepageViewModel.myExperimentsColumns);
        experiments = new JTable(state.getExperiments(), loadHomepageViewModel.experimentsColumns);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadHomepageController(LoadHomepageController loadHomepageController) {
        this.loadHomepageController = loadHomepageController;
    }






}
