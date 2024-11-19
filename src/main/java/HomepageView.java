package java;

import javax.swing.*;

public class HomepageView {

    private final String viewName = "homepage";
    private final LoadHompageViewModel loadHomepageViewModel;
    private final main.java.LoadHomepageController loadHomepageController;

    private final JButton newExperiment;
    private final JButton profile;

    private JTable experiments;
    private JTable myExperiments;

    public HomepageView(LoadHomepageViewModel loadHomepageViewModel){
        this.loadHomepageViewModel = loadHomepageViewModel;
        // add line about adding property change listener to viewmodel
        final JLabel title = new JLabel(loadHomepageViewModel.TITLE_LABEL);
        // add some set alignment thing

        // potentially create panels of title + table for both experiments and my experiment
        // idk where to add all the deets of that

        final JPanel experimentsPanel


        final JPanel myExperimentsPanel = new JPanel();
        // add title
        // create experiment button
        createExperiment = new JButton(LoadHomepageViewModel.CREATE_EXERIMENT_BUTTON_LABEL);
        // add table
        myExperiments = new JTable(loadHomepageViewModel.myExperimentsData, loadHomepageViewModel.myExperimentsColumns);







    }
}
