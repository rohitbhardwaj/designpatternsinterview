package behavioralpatterns.templatemethod;

/**
 * Concrete class for generating CSV reports.
 */
public class CSVReportGenerator extends ReportGenerator {
    @Override
    protected void fetchData() {
        System.out.println("Fetching data for CSV report...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing data for CSV report...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting report as a CSV file.");
    }
}