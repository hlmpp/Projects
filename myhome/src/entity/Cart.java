package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

    private Map<Items, Integer> goods;

    private double totalPrice;

    public Cart() {
        goods = new HashMap<>();
        totalPrice = 0.0;
    }

    public Map<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Items, Integer> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean addGoodsInCart(Items item, int number) {
        if (goods.containsKey(item)) {
            goods.put(item, goods.get(item) + number);
        } else {
            goods.put(item, number);
        }
        calTotalPrice();
        return true;
    }

    public boolean removeGoodsFromCart(Items item) {
        goods.remove(item);
        calTotalPrice();
        return true;
    }

    public double calTotalPrice() {
        double sum = 0.0;

        Set<Items> keys = goods.keySet();
        Iterator<Items> it = keys.iterator();

        while (it.hasNext()) {
            Items item = it.next();
            sum += item.getPrice() * goods.get(item);
        }

        setTotalPrice(sum);
        return sum;
    }

    public static void main(String[] args) {
        Items item1 = new Items(1, "沃特篮球鞋", "温州", 200, 500, "001.jpg");
        Items item2 = new Items(2, "李宁篮球鞋", "广州", 300, 500, "002.jpg");
        Items item3 = new Items(1, "沃特篮球鞋", "温州", 200, 500, "001.jpg");

        Cart cart = new Cart();
        cart.addGoodsInCart(item1, 1);
        cart.addGoodsInCart(item2, 2);
        cart.addGoodsInCart(item3, 3);

        Set<Map.Entry<Items, Integer>> entries = cart.getGoods().entrySet();
        for (Map.Entry<Items, Integer> item : entries) {
            System.out.println(item);
        }

        System.out.println("购物车总金额: " + cart.getTotalPrice());
    }
}
