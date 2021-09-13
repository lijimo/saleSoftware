import java.util.List;

public class Stock {
    List<Sale> sales;
    List<Article> soldArticles;
    List<Article> publishedArticles;
    List<Article> pendingArticles;
    List<Article> outOfStockArticles;

    // constructor
    public void Stock() {

    }

    public int getNumberOfArticlesSold() {
        return sales.size();
    }


    public void addSoldArticle(Sale s) {
        Article soldArticle = s.getArticle();
        this.soldArticles.add(soldArticle);
        int amount = soldArticle.getAmount();
        soldArticle.setAmount(amount-1);
        if (soldArticle.getAmount() == 0) {
            this.publishedArticles.remove(soldArticle);
            this.outOfStockArticles.add(soldArticle);
        }
    }

    public void addPublishedArticle(Article publishedArticle) {
        this.publishedArticles.add(publishedArticle);
        this.pendingArticles.remove(publishedArticle);
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
