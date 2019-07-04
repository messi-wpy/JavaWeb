package cn.ccnu.wpy.pojo;

public class ShoppingCart {

    private int id;
    private int productId;
    private int userId;
    private int number;

    public ShoppingCart(int id, int productId, int userId, int number) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
