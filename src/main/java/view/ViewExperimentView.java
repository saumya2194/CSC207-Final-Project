package view;

import interface_adapter.view_experiment.ViewExperimentController;
import interface_adapter.view_experiment.ViewExperimentState;
import interface_adapter.view_experiment.ViewExperimentViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * View for displaying experiment details and emailing them.
 */
public class ViewExperimentView extends JPanel implements PropertyChangeListener {

    private final String viewName = "View Experiment";
    private final ViewExperimentViewModel viewModel;

    private final JLabel title = new JLabel();
    private final JTextArea description = new JTextArea(5,20);
    private ViewExperimentController viewExperimentController;

    public ViewExperimentView(ViewExperimentViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);

        // Title setup
        final JLabel titleLabel = new JLabel(ViewExperimentViewModel.TITLE_LABEL);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Description setup
        final JLabel descriptionLabel = new JLabel(ViewExperimentViewModel.DESCRIPTION_LABEL);
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        JScrollPane descriptionScrollPane = new JScrollPane(description);

        // Layout setup
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titleLabel);
        this.add(Box.createVerticalStrut(10));
        this.add(descriptionLabel);
        this.add(descriptionScrollPane);
        this.add(Box.createVerticalStrut(10));

        // Initialize with current state
        updateView(viewModel.getState());
    }

    public void setViewExperimentController(ViewExperimentController controller) {
        this.viewExperimentController = controller;
    }

    private void updateView(ViewExperimentState state) {
        title.setText(state.getTitle());
        description.setText(state.getDetails());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateView((ViewExperimentState) evt.getNewValue());
        }
    }

    public String getViewName(){ return viewName; }
}
