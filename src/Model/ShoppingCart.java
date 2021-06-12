package Model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String,Integer> cart = new HashMap<String,Integer>();


    public void addToCart(String BookId, int quantity){
        cart.put(BookId,quantity);

    }

    public void removeFromCart(String BookId){
        cart.remove(BookId);
    }

}
