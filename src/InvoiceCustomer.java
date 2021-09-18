import java.time.LocalDate;

public class InvoiceCustomer extends Invoice {
    Address businessAddress;
    Address customerAddress;
    Sale sale;

    public void Invoice(Address customerAddress, Sale sale){
        Address business = new Address();
        business.businessName = "morlokshop";
        business.name = "Lisann Morlok";
        business.street = "Max-Himmelheber-Str.";
        business.streetNumber = "6";
        business.plz = "72270";
        business.city = "Baiersbronn";
        this.pathToInvoicePDF = "";
        this.businessAddress = business;
        this.customerAddress = customerAddress;
        this.sale = sale;
        this.date = LocalDate.now();
        this.article = this.sale.getArticle();
    }

    public void Invoice(Address customerAddress, Sale sale, LocalDate date) {
        Invoice(customerAddress, sale);
        this.date = date;
    }

    public void Invoice(Address customerAddress, Sale sale, String pathToInvoice){
        Invoice(customerAddress, sale);
        this.pathToInvoicePDF = pathToInvoice;
    }

    public void Invoice(Address customerAddress, Sale sale, String pathToInvoice, LocalDate date) {
        Invoice(customerAddress, sale, pathToInvoice);
        this.date = date;
    }

    public void generateInvoice() {
        Address b = this.businessAddress;
        Address c = this.customerAddress;
        int n = this.sale.getOrderNumber();
        LocalDate d = this.date;
        String a = this.article.getName();
        int x = this.sale.getAmount();
        double p = this.sale.getSalePrice();
        double g = this.sale.getShippingCost();
        double z = this.sale.getIncome();

    }

    public String getPathToInvoicePDF() {
        return pathToInvoicePDF;
    }

    public void setPathToInvoicePDF(String pathToInvoicePDF) {
        this.pathToInvoicePDF = pathToInvoicePDF;
    }

    public Address getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
