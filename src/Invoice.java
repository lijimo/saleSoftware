import java.time.LocalDate;

public abstract class Invoice {
    public LocalDate date;
    public Article article;
    public double price;
    public String pathToInvoicePDF;
    public int invoiceNumber;

    public abstract void generateInvoice();
}
