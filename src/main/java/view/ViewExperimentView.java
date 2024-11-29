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
    private final JTextArea description = new JTextArea(5, 20);
    private final JLabel emailLabel = new JLabel("Want to recieve an email with experiment details?");
    private final JButton emailButton = new JButton(ViewExperimentViewModel.EMAIL_BUTTON_LABEL);
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

        // Email button
        emailLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        emailButton.addActionListener(e -> emailExperimentDetails());

        // Layout setup
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titleLabel);
        this.add(title);
        this.add(Box.createVerticalStrut(10));
        this.add(descriptionLabel);
        this.add(descriptionScrollPane);
        this.add(Box.createVerticalStrut(10));
        this.add(emailLabel);
        this.add(emailButton);

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

    private void emailExperimentDetails() {
        if (viewExperimentController != null) {
            String titleText = title.getText();
            String detailsText = description.getText();
            viewExperimentController.emailExperimentDetails(titleText, detailsText);
        } else {
            JOptionPane.showMessageDialog(this, "Controller not set!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateView((ViewExperimentState) evt.getNewValue());
        }
    }

    public String getViewName(){ return viewName; }
}
