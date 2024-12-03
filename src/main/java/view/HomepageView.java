package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import entity.CommonStudy;
import interface_adapter.load_homepage.LoadHomepageController;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;

public class HomepageView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "homepage";
    private final HomepageViewModel homepageViewModel;
    private LoadHomepageController loadHomepageController;

    private final JButton createExperiment;
    private final JButton profile;

    // do the tables belong here?
    private final String[] columns = {"ID", "Name"};
    private JTable experiments = new JTable(1,1);
    private JTable myExperiments = new JTable(1,1);

    public HomepageView(HomepageViewModel homepageViewModel){
        this.homepageViewModel = homepageViewModel;
        this.homepageViewModel.addPropertyChangeListener(this);
        // state
        HomepageState state = homepageViewModel.getState();

        // Main title
        final JLabel title = new JLabel(HomepageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 36));

        // Compiling the stuff to populate the table
        Object[][] experimentsStrings = new Object[state.getExperiments().length][2];
        for (int i = 0; i < state.getExperiments().length; i++) {
            CommonStudy study = state.getExperiments()[i];
            experimentsStrings[i] = new Object[]{study.getId(), study.getTitle()};
        }

        Object[][] myExperimentsStrings = new Object[state.getMyExperiments().length][2];
        for (int i = 0; i < state.getMyExperiments().length; i++) {
            CommonStudy study = state.getMyExperiments()[i];
            myExperimentsStrings[i] = new Object[]{study.getId(), study.getTitle()};
        }

        experiments = new JTable(experimentsStrings, HomepageViewModel.experimentsColumns);
        myExperiments = new JTable(myExperimentsStrings, HomepageViewModel.myExperimentsColumns);

        // Create panels for experiments
        final JPanel myExperimentsPanel = new JPanel();
        myExperimentsPanel.setLayout(new BoxLayout(myExperimentsPanel, BoxLayout.Y_AXIS)); // Use BoxLayout
        myExperimentsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        final JLabel myExperimentsTitle = new JLabel(HomepageViewModel.MY_EXPERIMENTS_TITLE_LABEL);
        myExperimentsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        createExperiment = new JButton(HomepageViewModel.CREATE_EXPERIMENT_BUTTON_LABEL);
        profile = new JButton(HomepageViewModel.PROFILE_BUTTON_LABEL);
        myExperimentsPanel.add(myExperimentsTitle);
        myExperimentsPanel.add(createExperiment);
        myExperimentsPanel.add(profile);
        myExperimentsPanel.add(myExperiments);

        // Panel for other experiments
        final JPanel experimentsPanel = new JPanel();
        experimentsPanel.setLayout(new BoxLayout(experimentsPanel, BoxLayout.Y_AXIS)); // BoxLayout for vertical stacking
        experimentsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        final JLabel experimentsTitle = new JLabel(HomepageViewModel.EXPERIMENTS_TITLE_LABEL);
        experimentsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        experimentsPanel.add(experimentsTitle);
        experimentsPanel.add(experiments);

        // Buttons with ActionListeners
        createExperiment.addActionListener(evt -> loadHomepageController.switchToCreateStudyView());

        profile.addActionListener(evt -> {
            String username = homepageViewModel.getState().getUsername();
            loadHomepageController.switchToViewProfileView(username);
        });
      
        createExperiment.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {loadHomepageController.switchToCreateStudyView();}
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
        

        // Double-click listener for myExperiments
        myExperiments.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount() == 2) {
                    String data = myExperiments.getValueAt(myExperiments.getSelectedRow(), 0).toString();
                    loadHomepageController.switchToEditExperimentView(data);
                }
            }
        });

        // Double-click listener for experiments
        experiments.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount() == 2) {
                    String data = experiments.getValueAt(experiments.getSelectedRow(), 0).toString();
                    loadHomepageController.switchToViewExperimentView(data);
                }
            }
        });

        // Layout and adding components
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Stack components vertically
        this.add(title);
        this.add(profile);
        this.add(experimentsPanel);
        this.add(myExperimentsPanel);
    }

    // TODO: ADD ACTION PERFORMED THING
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
        }
        myExperiments = new JTable(myExperimentsStrings, columns);
        experiments = new JTable(experimentsStrings, columns);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadHomepageController(LoadHomepageController loadHomepageController) {
        this.loadHomepageController = loadHomepageController;
    }

}
