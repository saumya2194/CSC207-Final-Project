package entity;

/**
 * Factory for creating CommonUser objects.
 */

public class CommonStudyFactory implements StudyFactory {

    @Override
    public CommonStudy create(String user, String title, String details) {
        return new CommonStudy(user, title, details);
    }

    public CommonStudy create(String user, String title, String details, String id) {
        return new CommonStudy(user, title, details, id);
    }
}
