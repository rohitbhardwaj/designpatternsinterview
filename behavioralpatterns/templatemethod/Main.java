package behavioralpatterns.templatemethod;

public class Main {
    public static void main(String[] args) {
        // Generate PDF report
        ReportGenerator pdfReport = new PDFReportGenerator();
        System.out.println("Generating PDF Report:");
        pdfReport.generateReport();

        System.out.println();

        // Generate CSV report
        ReportGenerator csvReport = new CSVReportGenerator();
        System.out.println("Generating CSV Report:");
        csvReport.generateReport();
    }
}