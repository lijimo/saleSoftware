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

    // add new sale
    public void addNewSale(Sale sale) throws NotPublishedException, NotAvailableException {
        this.sales.add(sale);
        Article article = sale.getArticle();
        addArticleToSold(article);
    }

    // delete a sale, for example if it was added by mistake
    public void deleteSale(Sale sale) throws SaleNotExistException {
        if (!this.sales.contains(sale))   {
            throw new SaleNotExistException();
        }
        Article article = sale.getArticle();
        this.sales.remove(sale);
        deleteArticleFromSold(article);
    }

    // add new pending item
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
        if (this.outOfStockArticles.contains(pending)) {
            this.outOfStockArticles.remove(pending);
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

    // add article to sold stock
    public void addArticleToSold(Article sold) throws NotAvailableException, NotPublishedException{
        if (sold.getAmountAvailable() <= 0) {
            throw new NotAvailableException();
        }
        if (sold.online == false) {
            throw new NotAvailableException();
        }
        if (!this.publishedArticles.contains(sold)) {
            throw new NotPublishedException();
        }
        // reduce available amount
        sold.setAmountAvailable(sold.getAmountAvailable() - 1);
        sold.setAmountSold(sold.getAmountSold() + 1);
        if (!this.soldArticles.contains(sold)) {
            this.soldArticles.add(sold);
        }
        if (sold.amountAvailable == 0) {
            deletePublishedArticle(sold);
            sold.setOnline(false);
            if (!this.outOfStockArticles.contains(sold))   {
                      this.outOfStockArticles.add(sold);
            }

        }

    }

    // remove article from sold
    public void deleteArticleFromSold(Article sold) throws SaleNotExistException {
        if (!this.soldArticles.contains(sold)) {
            throw new SaleNotExistException();
        }
        this.soldArticles.remove(sold);
        sold.setAmountAvailable(sold.getAmountAvailable() + 1);
        sold.setAmountSold(sold.getAmountSold() - 1);
        if (this.outOfStockArticles.contains(sold)) {
            this.outOfStockArticles.remove(sold);
        }
        if (!this.publishedArticles.contains(sold)) {
            this.publishedArticles.add(sold);
        }
    }


    public int getTotalNumberOfArticlesSold() {
        int counter = 0;
        for (Article sold : this.soldArticles) {
            counter = counter + sold.getAmountSold();
        }
        return counter;
    }

    public int getTotalNumberOfPublishedArticles() {
        return counterOfAmountAvailable(this.publishedArticles);
    }

    public int getTotalNumberOfPendingArticles() {
        return counterOfAmountAvailable(this.pendingArticles);
    }

    public int counterOfAmountAvailable(List<Article> list) {
        int counter = 0;
        for (Article article : list) {
            counter += article.getAmountAvailable();
        }
        return counter;
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
