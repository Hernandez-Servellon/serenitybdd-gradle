package starter.models;

public class TransactionModel {
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionAmaunt() {
        return transactionAmaunt;
    }

    public void setTransactionAmaunt(String transactionAmaunt) {
        this.transactionAmaunt = transactionAmaunt;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    private String transactionDate;
    private String transactionAmaunt;
    private String transactionDescription;
}
