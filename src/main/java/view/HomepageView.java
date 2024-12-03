package view;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.CommonStudy;
import interface_adapter.load_homepage.LoadHomepageController;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;

public class HomepageView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "homepage";
    private final HomepageViewModel homepageViewModel;
    private LoadHomepageController loadHomepageController;

    private final JButton viewExperiment;
    private final JButton editExperimentbutton;
    private final JButton createExperiment;
    private final JButton profile;

    // do the tables belong here?
    private final String[] columns = {"ID", "Name"};
//    private JTable experiments = new JTable(new DefaultTableModel(null, columns ));
    private JTable experiments = new JTable(1,1);
//    private JTable myExperiments = new JTable(new DefaultTableModel(null, columns ));
    private JTable myExperiments = new JTable(1,1);

    public HomepageView(HomepageViewModel homepageViewModel){
        this.homepageViewModel = homepageViewModel;
        // add line about adding property change listener to viewmodel, not 100% sure what its for
        this.homepageViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(HomepageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        // add some set alignment thing

        // potentially create panels of title + table for both experiments and my experiment
        // idk where to add all the deets of that

        final JPanel myExperimentsPanel = new JPanel();
        // add title(might be included in columns)
        // create experiment button
        final JLabel myExperimentsTitle = new JLabel(HomepageViewModel.MY_EXPERIMENTS_TITLE_LABEL);
        myExperimentsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        createExperiment = new JButton(HomepageViewModel.CREATE_EXPERIMENT_BUTTON_LABEL);
        editExperimentbutton = new JButton(HomepageViewModel.EDIT_EXPERIMENT_BUTTON_LABEL);
        viewExperiment = new JButton(HomepageViewModel.VIEW_EXPERIMENT_BUTTON_LABEL);
        profile = new JButton(HomepageViewModel.PROFILE_BUTTON_LABEL);
        myExperimentsPanel.add(myExperimentsTitle);
        myExperimentsPanel.add(createExperiment);

        myExperimentsPanel.add(editExperimentbutton);
        myExperimentsPanel.add(viewExperiment);
        myExperimentsPanel.add(profile);
        myExperimentsPanel.add(myExperiments);


        myExperimentsPanel.add(myExperiments);
        final JPanel experimentsPanel = new JPanel();
        // add title(might be included in column)
        // add table
        final JLabel experimentsTitle = new JLabel(HomepageViewModel.EXPERIMENTS_TITLE_LABEL);
        experimentsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        experimentsPanel.add(experimentsTitle);
        experimentsPanel.add(experiments);
      
        // Buttons with ActionListeners
        profile.addActionListener(evt -> {
            String username = homepageViewModel.getState().getUsername();
            loadHomepageController.switchToViewProfileView(username);
        });
      
        createExperiment.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        final HomepageState currentState = homepageViewModel.getState();
                        String username = currentState.getUsername();
                        loadHomepageController.switchToCreateStudyView(username);}
                }
        );

        editExperimentbutton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        final HomepageState currentState = homepageViewModel.getState();
                        loadHomepageController.switchToEditExperimentView(currentState.getUsername());
                    }
                }
        );

        viewExperiment.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        final HomepageState currentState = homepageViewModel.getState();
                        loadHomepageController.switchToEnterIDView(currentState.getUsername());
                    }
                }
        );

        profile.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    // Retrieve the username from the HomepageViewModel state
                    final HomepageState currentState = homepageViewModel.getState();
                    String username = currentState.getUsername();

                    // Pass the username to the controller

                    loadHomepageController.switchToViewProfileView(username);
                }
            }
        );

        this.add(title);
        this.add(profile);
        this.add(experimentsPanel);
        this.add(myExperimentsPanel);

    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final HomepageState state = (HomepageState) evt.getNewValue();
        setTables(state);

    }

    private void setTables(HomepageState state) {
        Object[][] experimentsStrings = new Object[state.getExperiments().length][2];
        for (int i = 0; i < state.getExperiments().length; i++) {
            CommonStudy study = state.getExperiments()[i];
            experimentsStrings[i] = new Object[]{study.getId(), study.getTitle()};
        }

        Object[][] myExperimentsStrings = new Object[state.getMyExperiments().length][2];
        for (int i = 0; i < state.getMyExperiments().length; i++) {
            CommonStudy study = state.getMyExperiments()[i];
            myExperimentsStrings[i] = new Object[]{study.getId(), study.getTitle()};
            myExperiments = new JTable(myExperimentsStrings, HomepageViewModel.myExperimentsColumns);
            experiments = new JTable(experimentsStrings, HomepageViewModel.experimentsColumns);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadHomepageController(LoadHomepageController loadHomepageController) {
        this.loadHomepageController = loadHomepageController;
    }

}
