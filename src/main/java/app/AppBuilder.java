
//package app;
//
//import java.awt.CardLayout;
//
//import javax.swing.JPanel;
//
//import entity.CommonUserFactory;
//import entity.UserFactory;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.homepage.LoadHompageViewModel;
//import interface_adapter.login.LoginController;
//import interface_adapter.login.LoginPresenter;
//import interface_adapter.login.LoginViewModel;
//import interface_adapter.signup.SignupController;
//import interface_adapter.signup.SignupPresenter;
//import interface_adapter.signup.SignupViewModel;
//import use_case.login.LoginInputBoundary;
//import use_case.login.LoginInteractor;
//import use_case.login.LoginOutputBoundary;
//import use_case.signup.SignupInputBoundary;
//import use_case.signup.SignupInteractor;
//import use_case.signup.SignupOutputBoundary;
//import view.LoggedInView;
//import view.LoginView;
//import view.SignupView;
//import view.ViewManager;
//
///**
// * The AppBuilder class is responsible for putting together the pieces of
// * our CA architecture; piece by piece.
// * <p/>
// * This is done by adding each View and then adding related Use Cases.
// */
//// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
////                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
////                  your team to think about ways to refactor the code to resolve these
////                  if your team decides to work with this as your starter code
////                  for your final project this term.
//public class AppBuilder {
//    private final JPanel cardPanel = new JPanel();
//    private final CardLayout cardLayout = new CardLayout();
//    // thought question: is the hard dependency below a problem?
//    private final UserFactory userFactory = new CommonUserFactory();
//    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
//    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);
//
//    private SignupView signupView;
//    private SignupViewModel signupViewModel;
//    private LoginViewModel loginViewModel;
//    private LoadHompageViewModel loadHompageViewModel;
//    private LoggedInView loggedInView;
//    private LoginView loginView;
//
//    public AppBuilder() {
//        cardPanel.setLayout(cardLayout);
//    }
//
//    /**
//     * Adds the Signup View to the application.
//     * @return this builder
//     */
//    public AppBuilder addSignupView() {
//        signupViewModel = new SignupViewModel();
//        signupView = new SignupView(signupViewModel);
//        cardPanel.add(signupView, signupView.getViewName());
//        return this;
//    }
//
//    /**
//     * Adds the Login View to the application.
//     * @return this builder
//     */
//    public AppBuilder addLoginView() {
//        loginViewModel = new LoginViewModel();
//        loginView = new LoginView(loginViewModel);
//        cardPanel.add(loginView, loginView.getViewName());
//        return this;
//    }
//
//    /**
//     * Adds the LoggedIn View to the application.
//     * @return this builder
//     */
//    public AppBuilder addLoggedInView() {
//        loadHompageViewModel = new LoadHompageViewModel();
//        loggedInView = new LoggedInView(loadHompageViewModel);
//        cardPanel.add(loggedInView, loggedInView.getViewName());
//        return this;
//    }
//
//    /**
//     * Adds the Signup Use Case to the application.
//     * @return this builder
//     */
//    public AppBuilder addSignupUseCase() {
//        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
//                signupViewModel, loginViewModel);
//        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
//                userDataAccessObject, signupOutputBoundary, userFactory);
//
//        final SignupController controller = new SignupController(userSignupInteractor);
//        signupView.setSignupController(controller);
//        return this;
//    }
//
//    /**
//     * Adds the Login Use Case to the application.
//     * @return this builder
//     */
//    public AppBuilder addLoginUseCase() {
//        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
//                loadHompageViewModel, loginViewModel);
//        final LoginInputBoundary loginInteractor = new LoginInteractor(
//                userDataAccessObject, loginOutputBoundary);
//
//        final LoginController loginController = new LoginController(loginInteractor);
//        loginView.setLoginController(loginController);
//        return this;
//    }

import javax.swing.*;

import data_access.DBExperimentDataAccessObject;
import data_access.DBUserDataAccessObject;
import entity.CommonStudyFactory;
import entity.CommonUserFactory;
import entity.StudyFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.createstudy.CreateStudyViewModel;
import interface_adapter.load_homepage.HomepageViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.view_experiment.ViewExperimentViewModel;
import interface_adapter.view_profile.ProfileViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.*;

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
    private final DBExperimentDataAccessObject experimentDataAccessObject = new DBExperimentDataAccessObject(studyFactory, userFactory);
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
    private EditExperimentViewModel editExperimentViewModel;

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
     * Adds the LoggedIn View to the application.
     *
     * @return this builder
     */
    public AppBuilder addHomepageView() {
        homepageViewModel = new HomepageViewModel();
        homepageView = new HomepageView(homepageViewModel);
        cardPanel.add(homepageView, homepageView.getViewName());
        return this;
    }


    public AppBuilder addCreateStudyView() {
        createStudyViewModel = new CreateStudyViewModel();
        createStudyView = new HomepageView(createStudyViewModel);
        cardPanel.add(createStudyView, createStudyView.getViewName());
        return this;
    }

    public AppBuilder addProfileView() {
        profileViewModel = new ProfileViewModel();
        profileView = new ProfileView(profileViewModel);
        cardPanel.add(profileView, profileView.getViewName());
        return this;
    }

    public AppBuilder addEditExperimentView() {
        editExperimentViewModel = new EditExperimentViewModel();
        editExperimentView = new EditExperimentView(editExperimentViewModel);
        cardPanel.add(editExperimentView, editExperimentView.getViewName());
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
     * Adds the Login Use Case to the application.
     *
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                homepageViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    // The following will need significant adjustment


    public AppBuilder addLoadHomepageUseCase() {
        final LoadHomepageOutputBoundary loadHomepageOutputBoundary = new LoadHomepagePresenter(viewManagerModel,
                loadHomepageViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    // we must create add-----UseCase() methods for the remaining use cases and correct the one above



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

