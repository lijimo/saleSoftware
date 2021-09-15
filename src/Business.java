public class Business {
    Address businessAddress;
    String taxNumber;

    public void Business(Address businessAddress, String taxNumber) {
        this.businessAddress = businessAddress;
        this.taxNumber = taxNumber;
    }

    public Address getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
