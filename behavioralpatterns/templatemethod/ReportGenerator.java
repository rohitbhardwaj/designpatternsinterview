package behavioralpatterns.templatemethod;

/**
 * Abstract class defining the template for generating reports.
 */
public abstract class ReportGenerator {
    // Template method defining the algorithm structure
    public final void generateReport() {
        fetchData();
        processData();
        formatReport();
        saveReport();
    }

    // Steps to be implemented by subclasses
    protected abstract void fetchData();
    protected abstract void processData();
    protected abstract void formatReport();

    // Common step implemented in the abstract class
    protected void saveReport() {
        System.out.println("Saving the report to disk.");
    }
}

