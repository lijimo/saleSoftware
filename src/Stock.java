import java.util.List;

public class Stock {
    List<Sale> sales;
    List<Article> soldArticles;
    List<Article> publishedArticles;
    List<Article> pendingArticles;
    List<Article> outOfStockArticles;
    List<Sale> returnedSales;
    List<Article> returnedArticles;

    // constructor
    public void Stock() {

    }

    public int getTotalNumberOfArticlesSold() {
        return sales.size();
    }


    public void addSoldArticle(Sale s) {
        Article soldArticle = s.getArticle();
        int amountAvailable = soldArticle.getAmountAvailable();
        soldArticle.setAmountAvailable(amountAvailable-1);
        int amountSold = soldArticle.getAmountSold();
        soldArticle.setAmountSold(amountSold + 1);
        this.soldArticles.add(soldArticle);
        if (soldArticle.getAmountAvailable() == 0) {
            this.publishedArticles.remove(soldArticle);
            this.outOfStockArticles.add(soldArticle);
        }
    }

    public void addPublishedArticle(Article publishedArticle) {
        this.publishedArticles.add(publishedArticle);
        this.pendingArticles.remove(publishedArticle);
    }

    public void addPendingArticle(Article pendingArticle) {
        this.pendingArticles.add(pendingArticle);
    }

    public void removePendingArticle(Article pendingArticle) {
        this.pendingArticles.remove(pendingArticle);
    }

    public void addReturnedSale(Sale returnedSale) {
        this.returnedSales.add(returnedSale);
        this.sales.remove(returnedSale);
        this.returnedArticles.add(returnedSale.getArticle());
    }

    // setters & getters
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Article> getSoldArticles() {
        return soldArticles;
    }

    public void setSoldArticles(List<Article> soldArticles) {
        this.soldArticles = soldArticles;
    }

    public List<Article> getPublishedArticles() {
        return publishedArticles;
    }

    public void setPublishedArticles(List<Article> publishedArticles) {
        this.publishedArticles = publishedArticles;
    }

    public List<Article> getPendingArticles() {
        return pendingArticles;
    }

    public void setPendingArticles(List<Article> pendingArticles) {
        this.pendingArticles = pendingArticles;
    }

    public List<Article> getOutOfStockArticles() {
        return outOfStockArticles;
    }

    public void setOutOfStockArticles(List<Article> outOfStockArticles) {
        this.outOfStockArticles = outOfStockArticles;
    }
}
