import java.time.LocalDate;

public class Sale {
    Article article;
    int amount;
    LocalDate date;
    double salePrice;
    double shippingCost;
    double profit;
    double fee;
    boolean returned;
    double income;
    double tax;
    int orderNumber;
    InvoiceCustomer invoiceCustomer;
    ShippingLabel shippingLabel;

    // constructor
    public void Sale(Article article, int amount, double salePrice,
                     double shippingCost){
        this.article = article;
        this.amount = amount;
        this.date = LocalDate.now();
        this.salePrice = salePrice;
        this.shippingCost = shippingCost;
        this.fee = 0;
        this.profit = calculateProfit();
        this.income = calculateRevenue();
        this.returned = false;
    }

    public void Sale(Article article, double salePrice) {
        Sale(article, 1, salePrice, 4.99);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double calculateProfit() {
        return ((salePrice * amount) - fee - article.getPrice());
    }

    public double calculateRevenue(){
        return ((salePrice * amount) + shippingCost);
    }

    // getters & setters
    public Article getArticle() {
        return article;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public InvoiceCustomer getInvoice() {
        return invoiceCustomer;
    }

    public void setInvoice(InvoiceCustomer invoiceCustomer) {
        this.invoiceCustomer = invoiceCustomer;
    }

    public ShippingLabel getShippingLabel() {
        return shippingLabel;
    }

    public void setShippingLabel(ShippingLabel shippingLabel) {
        this.shippingLabel = shippingLabel;
    }

    public double getTax() {
        return tax;
    }
}
