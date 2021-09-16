import java.util.ArrayList;
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
        this.sales = new ArrayList<Sale>();
        this.soldArticles = new ArrayList<Article>();
        this.publishedArticles = new ArrayList<Article>();
        this.pendingArticles = new ArrayList<Article>();
        this.outOfStockArticles = new ArrayList<Article>();
        this.returnedArticles = new ArrayList<Article>();
        this.returnedSales = new ArrayList<Sale>();
    }

    // add a new item to the system
    public void addPendingArticle(Article pending) throws NotAvailableException {
        if (pending.getAmountAvailable() <= 0) {
            throw new NotAvailableException();
        }
        pending.setOnline(false);
        if (!this.pendingArticles.contains(pending)) {
            this.pendingArticles.add(pending);
        }
        if (this.publishedArticles.contains(pending)) {
            this.publishedArticles.remove(pending);
        }
    }

    // delete an article before being published
    public void deletePendingArticles(Article pending) {
        if (this.pendingArticles.contains(pending)) {
            this.pendingArticles.remove(pending);
        }
    }

    // move pending article to published stock
    public void addArticleToPublished(Article published) throws NotPendingException{
        if (!this.pendingArticles.contains(published)) {
            throw new NotPendingException();
        }
        this.publishedArticles.add(published);
        published.setOnline(true);
    }

    // delete a published article
    public void deletePublishedArticle(Article published) {
        if (this.publishedArticles.contains(published)) {
            published.setOnline(false);
            this.publishedArticles.remove(published);
        }
    }

    // move published article back to pending stock
    public void movePublishedArticleBackToPending(Article published) throws AlreadyPendingException, NotAvailableException{
        if (!this.publishedArticles.contains(published)) {
            throw new NotAvailableException();
        }
        if (this.pendingArticles.contains(published)) {
            throw new AlreadyPendingException();
        }
        published.setOnline(false);
        this.publishedArticles.remove(published);
        this.pendingArticles.add(published);
    }

    public int getTotalNumberOfArticlesSold() {
        return sales.size();
    }

    public void removePendingArticle(Article pendingArticle) {
        this.pendingArticles.remove(pendingArticle);
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
