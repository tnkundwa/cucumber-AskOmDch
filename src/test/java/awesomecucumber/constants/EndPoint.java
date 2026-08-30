package awesomecucumber.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNTS("/account"),
//    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    PRODUCT_CATEGORY("/product-category");

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
