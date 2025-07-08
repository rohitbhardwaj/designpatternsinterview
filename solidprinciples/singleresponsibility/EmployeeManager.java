package solidprinciples.singleresponsibility;

import java.util.ArrayList;
import java.util.List;

/*
Why it violates SRP:

The EmployeeManager class has multiple reasons to change:
If salary calculation changes.
If database operations change.
If report generation logic changes.

*/
public class EmployeeManager {
    @Override
    public String toString() {
        return "EmployeeManager []";
    }

    public void calculateSalary(final Employee employee) {
        // Logic to calculate salary
    }

    public void saveToDatabase(final Employee employee) {
        // Logic to save employee data to database
    }

    public void generateReport(final Employee employee) {
        // Logic to generate report
    }
}
/*
 * Common Violations of SRP
 * Multifunctional Classes: Classes that mix responsibilities like database
 * operations, business logic, and UI formatting.
 * 
 * Long Methods: A single method that performs multiple tasks, making it hard to
 * maintain and debug.
 * 
 * Hard-Coded Dependencies: Classes directly depending on specific
 * implementations instead of abstractions.
 */