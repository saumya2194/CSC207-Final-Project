package java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // add line about adding property change listener to viewmodel
        final JLabel title = new JLabel(loadHomepageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        // add some set alignment thing

        // potentially create panels of title + table for both experiments and my experiment
        // idk where to add all the deets of that

        final JPanel myExperimentsPanel = new JPanel();
        // add title(might be included in columns)
        // create experiment button
        createExperiment = new JButton(LoadHomepageViewModel.CREATE_EXPERIMENT_BUTTON_LABEL);
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
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {loadHomepageController.switchToLogoutView();}
                }
        );






    }

}
