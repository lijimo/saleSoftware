import java.time.LocalDate;

public class invoicePurchase extends Invoice{

    public void Invoice(Article article) {
        this.article = article;
        this.pathToInvoicePDF = "";
        this.price = this.article.getPrice() * this.article.getAmountAvailable();
        this.date = LocalDate.now();
    }

    public void Invoice(Article article, LocalDate date) {
        Invoice(article);
        this.date = date;
    }

    public void Invoice(Article article, LocalDate date, String pathToInvoice) {
        Invoice(article, date);
        this.pathToInvoicePDF = pathToInvoice;
    }

    @Override
    public void generateInvoice() {
        String a = article.getName();
        double p = this.price;
        LocalDate d = this.date;
    }
}
