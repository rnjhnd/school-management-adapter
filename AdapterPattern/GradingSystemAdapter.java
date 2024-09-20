public class GradingSystemAdapter implements SchoolManagementApp {
    private final GradingSystem gradingSystem;

    public GradingSystemAdapter(GradingSystem gradingSystem) {
        this.gradingSystem = gradingSystem;
    }

    @Override
    public String integrateSystem() {
        return gradingSystem.recordGrades();
    }
}