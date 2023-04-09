// to optimize order and delivery
// fish - 5 mins
// chicken - 10 mins
// lamb - 15 mins
// qty = 1
// each customer can order only one type of food
// VIP is priority
// order>60mins is priortize

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    static HashMap<Integer,Order> orderlist = new HashMap<>();
    static int key=1; // variable to store the respective keys

    public static void main(String[] args) {
        Order order1 = new Order("lamb");
        Order order2 = new Order("chicken");
        Order order3 = new Order("fish");
        Order order4 = new Order("lamb");
        Order order5 = new Order("chicken");
        
        nextOrder();
        takeOrder(order1);
        takeOrder(order2);
        takeOrder(order3);
        nextOrder();
        takeOrder(order4);
        takeOrder(order5);
        nextOrder();
    }
    
    //Overall complexity of this method O(n^2) , assuming number of orders <=10~20 always
    public static Order nextOrder() {
        // if orderlist is empty
        // complexity O(1)
        if (orderlist.isEmpty()) {
            System.out.println("Order List is empty!! Let's wait for orders");
            return null;
        }

        // if list size = 1
        // complexity O(1)
        if (orderlist.size() == 1) {
            Order order = orderlist.values().iterator().next();
            System.out.println(order.getFoodType() + " Order Ready!");
            orderlist.remove(1); // delete the items from orderlist once delivered/prepared
            return order;
        }

        //  if size>1 , look for fish first then chicken and then lamb
        // complexity O(n^2) but size the orderlist is never going to be too big , so this can still be low
        for (String foodType : new String[]{"fish", "chicken", "lamb"}) {
            orderlist.values().removeIf(order -> order.getFoodType().equals(foodType)); // delete the items from orderlist once delivered/prepared
            System.out.println(foodType + " Order Ready!");
        }


        return null;
    }
    
    // complexity O(1)
    public static void takeOrder(Order order) {
        orderlist.put(key,order);
        key++;
    }
}




