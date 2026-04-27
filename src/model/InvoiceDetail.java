package model;

public class InvoiceDetail {
    private int productId;
    private int quantity;
    private double price;

    public InvoiceDetail(int productId,int quantity,double price){
        this.productId=productId;
        this.quantity=quantity;
        this.price=price;
    }

    public int getProductId(){return productId;}
    public int getQuantity(){return quantity;}
    public double getPrice(){return price;}
}