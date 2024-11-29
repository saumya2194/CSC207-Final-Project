package java.view;

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

import java.interface_adapter.load_homepage.LoadHomepageController;
import java.interface_adapter.load_homepage.HomepageState;

public class HomepageView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "homepage";
    private final java.interface_adapter.load_homepage.HomepageViewModel homepageViewModel;
    private LoadHomepageController loadHomepageController;

    private final JButton createExperiment;
    private final JButton profile;

    // do the tables belong here?
    private JTable experiments = new JTable(new Object[][], homepageViewModel.experimentsColumns);;
    private JTable myExperiments = new JTable(new Object[][], homepageViewModel.myExperimentsColumns);;

    public HomepageView(LoadHomepageController controller, java.interface_adapter.load_homepage.HomepageViewModel homepageViewModel){
        this.homepageViewModel = homepageViewModel;
        // add line about adding property change listener to viewmodel, not 100% sure what its for
        this.homepageViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(homepageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        // add some set alignment thing

        // potentially create panels of title + table for both experiments and my experiment
        // idk where to add all the deets of that

        final JPanel myExperimentsPanel = new JPanel();
        // add title(might be included in columns)
        // create experiment button
        final JLabel myExperimentsTitle = new JLabel(homepageViewModel.MY_EXPERIMENTS_TITLE_LABEL);
        myExperimentsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        createExperiment = new JButton(java.interface_adapter.load_homepage.HomepageViewModel.CREATE_EXPERIMENT_BUTTON_LABEL);
        profile = new JButton(java.interface_adapter.load_homepage.HomepageViewModel.PROFILE_BUTTON_LABEL);
        myExperimentsPanel.add(myExperimentsTitle);
        myExperimentsPanel.add(createExperiment);
        // add table


        myExperimentsPanel.add(myExperiments);
        final JPanel experimentsPanel = new JPanel();
        // add title(might be included in column)
        // add table
        final JLabel experimentsTitle = new JLabel(homepageViewModel.EXPERIMENTS_TITLE_LABEL);
        experimentsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        experimentsPanel.add(experimentsTitle);
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
        

        // TODO: WHERE TO TAKE?
        myExperiments.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount == 2){
                    // what to do when double click occurs
                    String data = myExperiments.getValueAt(myExperiments.getSelectedRow(), 0).toString();
                    // I could input the experiment id into the controller of the experiments thing
                    loadHomepageController.switchTo....

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
        this.add(experimentsPanel);
        this.add(myExperimentsPanel);

    }

    // TODO: ADD ACTION PERFORMED THING

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final HomepageState state = (HomepageState) evt.getNewValue();
        setTables(state);

    }

    private void setTables(HomepageState state) {
        myExperiments = new JTable(state.getMyExperiments(), homepageViewModel.myExperimentsColumns);
        experiments = new JTable(state.getExperiments(), homepageViewModel.experimentsColumns);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadHomepageController(LoadHomepageController loadHomepageController) {
        this.loadHomepageController = loadHomepageController;
    }






}
