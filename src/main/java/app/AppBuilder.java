package app;

import java.awt.CardLayout;

import javax.swing.*;

import data_access.DBExperimentDataAccessObject;
import data_access.DBUserDataAccessObject;
import entity.CommonStudyFactory;
import entity.CommonUserFactory;
import entity.StudyFactory;
import entity.UserFactory;
import interface_adapter.EditStudy.EditStudyViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.createstudy.CreateStudyController;
import interface_adapter.createstudy.CreateStudyPresenter;
import interface_adapter.createstudy.CreateStudyViewModel;
import interface_adapter.load_homepage.HomepageViewModel;
import interface_adapter.load_homepage.LoadHomepageController;
import interface_adapter.load_homepage.LoadHomepagePresenter;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.view_experiment.ViewExperimentViewModel;
import interface_adapter.view_profile.EditProfilePresenter;
import interface_adapter.view_profile.ProfileViewModel;
import use_case.createstudy.CreateStudyInputBoundary;
import use_case.createstudy.CreateStudyInteractor;
import use_case.createstudy.CreateStudyOutputBoundary;
import use_case.load_homepage.LoadHomepageInputBoundary;
import use_case.load_homepage.LoadHomepageInteractor;
import use_case.load_homepage.LoadHomepageOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.*;
import interface_adapter.view_experiment.ViewExperimentViewModel;
import interface_adapter.view_profile.ProfileViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.edit_profile.EditProfileInputBoundary;
import use_case.edit_profile.EditProfileInteractor;
import interface_adapter.view_profile.EditProfileController;
import interface_adapter.view_profile.ProfileViewModel;



/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.


public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new CommonUserFactory();
    private final StudyFactory studyFactory = new CommonStudyFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?(line from starter code)
    private final DBExperimentDataAccessObject studyDataAccessObject = new DBExperimentDataAccessObject(studyFactory, userFactory);
    private final DBUserDataAccessObject userDataAccessObject = new DBUserDataAccessObject(userFactory);

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoginView loginView;
    private HomepageView homepageView;
    private HomepageViewModel homepageViewModel;
    private CreateStudyView createStudyView;
    private CreateStudyViewModel createStudyViewModel;
    private ProfileView profileView;
    private ProfileViewModel profileViewModel;
    private ViewExperimentView viewExperimentView;
    private ViewExperimentViewModel viewExperimentViewModel;
    private EditExperimentView editExperimentView;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     *
     * @return this builder
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Homepage View to the application.
     *
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the Create Study View to the application.
     *
     * @return this builder
     */
    public AppBuilder addCreateStudyView() {
        createStudyViewModel = new CreateStudyViewModel();
        createStudyView = new CreateStudyView(createStudyViewModel);
        cardPanel.add(createStudyView, createStudyView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    /**
     * Adds the Profile View to the application.
     *
     * @return this builder
     */
    public AppBuilder addProfileView() {
        profileViewModel = new ProfileViewModel();
        profileView = new ProfileView(profileViewModel);
        cardPanel.add(profileView, profileView.getViewName());
        return this;
    }

    /**
     * Adds the Experiment View to the application.
     *
     * @return this builder
     */
    /*public AppBuilder addViewExperimentView() {
        viewExperimentViewModel = new ViewExperimentViewModel();
        viewExperimentView = new ProfileView(viewExperimentViewModel);
        cardPanel.add(viewExperimentView, viewExperimentView.getViewName());
        return this;
    }

    /**
     * Adds the Homepage View to the application.
     *
     * @return this builder
     */
    public AppBuilder addHomepageView() {
        homepageViewModel = new HomepageViewModel();
        homepageView = new HomepageView(homepageViewModel);
        cardPanel.add(homepageView, homepageView.getViewName());
        return this;
    }




    /**
     * Adds the Signup Use Case to the application.
     *
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Signup Use Case to the application.
     *
     * @return this builder
     */
    public AppBuilder addCreateStudyUseCase() {
        final CreateStudyOutputBoundary createStudyOutputBoundary = new CreateStudyPresenter(viewManagerModel,
                homepageViewModel, createStudyViewModel);
//        final CreateStudyInputBoundary createStudyInteractor = new CreateStudyInteractor(
//                studyDataAccessObject, createStudyOutputBoundary, studyFactory);
//
//        final CreateStudyController controller = new CreateStudyController(createStudyInteractor);
//        createStudyView.setCreateStudyController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     *
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel,
                homepageViewModel);

        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }



    // The following will need significant adjustment


    /**
     * Adds the Homepage Use Case to the application.
     *
     * @return this builder
     */
    public AppBuilder addHomepageUseCase() {
//        final LoadHomepageOutputBoundary homepageOutputBoundary = new LoadHomepagePresenter(viewManagerModel, profileViewModel,
//                createStudyViewModel, new EditStudyViewModel(), loginViewModel, homepageViewModel);
//
//        final LoadHomepageInputBoundary homepageInteractor = new LoadHomepageInteractor(
//                homepageOutputBoundary, studyDataAccessObject);
//
//        final LoadHomepageController homepageController = new LoadHomepageController(homepageInteractor);
//        loggedInView.setLoadHomepageController(homepageController);
//        return this;
        return this;
    }

    /**
     * Adds the Profile View Use Case to the application.
     *
     * @return this builder
     */
    public AppBuilder addEditProfileUseCase() {
        final EditProfileOutputBoundary editProfileOutputBoundary = new EditProfilePresenter(homepageViewModel,
                viewManagerModel);

        final EditProfileInputBoundary editProfileInteractor = new EditProfileInteractor(userDataAccessObject,
                editProfileOutputBoundary,
                userFactory);

        final EditProfileController editProfileController = new EditProfileController(editProfileInteractor);
        profileView.setChangePasswordController(editProfileController);
        return this;
    }


    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }


}