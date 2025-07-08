package behavioralpatterns.templatemethod;

/**
 * Concrete class for generating PDF reports.
 */
public class PDFReportGenerator extends ReportGenerator {
    @Override
    protected void fetchData() {
        System.out.println("Fetching data for PDF report...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing data for PDF report...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting report as a PDF document.");
    }
}