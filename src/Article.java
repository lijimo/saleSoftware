import java.util.ArrayList;
import java.util.List;

public class Article {
    public String name;
    public String brand;
    public double price;
    public int amountAvailable;
    public int amountSold;
    public String link;
    public String description;
    public InvoiceCustomer invoiceCustomer;
    public List<photo> photos;
    public photo logo;
    public boolean online;

    // constructors
    public void Article(String name, String brand, double price, int amount, String link, String description,
                        InvoiceCustomer invoiceCustomer, List<photo> photos, photo logo) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.amountAvailable = amount;
        this.link = link;
        this.description = description;
        this.invoiceCustomer = invoiceCustomer;
        this.photos = photos;
        this.logo = logo;
        this.online = false;
    }

    public void Article(String name, double price) {
        InvoiceCustomer invoiceCustomerDefault = new InvoiceCustomer();
        List<photo> photosDefault = new ArrayList<photo>();
        photo logoDefault = new photo();
        Article(name, "", price, 1, "", "",
                invoiceCustomerDefault, photosDefault, logoDefault );
    }

    public int getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInvoice(InvoiceCustomer invoiceCustomer) {
        this.invoiceCustomer = invoiceCustomer;
    }

    public void setPhotos(List<photo> photos) {
        this.photos = photos;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public InvoiceCustomer getInvoice() {
        return invoiceCustomer;
    }

    public List<photo> getPhotos() {
        return photos;
    }

    public photo getLogo() {
        return logo;
    }

    public void setLogo(photo logo) {
        this.logo = logo;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
