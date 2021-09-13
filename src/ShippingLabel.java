public class ShippingLabel {
    String pathToPDFfile;
    Sale sale;

    public void ShippingLabel(String pathToPDFfile, Sale sale) {
        this.pathToPDFfile = pathToPDFfile;
        this.sale = sale;
    }

    public void ShippingLabel(Sale sale) {
        ShippingLabel("", sale);
    }

    public String getPathToPDFfile() {
        return pathToPDFfile;
    }

    public void setPathToPDFfile(String pathToPDFfile) {
        this.pathToPDFfile = pathToPDFfile;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

}
