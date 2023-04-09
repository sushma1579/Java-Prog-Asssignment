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
    static int key=1;

    public static void main(String[] args) {
        Order order1 = new Order("lamb");
        Order order2 = new Order("chicken");
        Order order3 = new Order("fish");
        Order order4 = new Order("lamb");
        Order order5 = new Order("chicken");

        takeOrder(order1);
        takeOrder(order2);
        takeOrder(order3);
        nextOrder();
        takeOrder(order4);
        takeOrder(order5);
        nextOrder();
    }

    public static Order nextOrder() {
        if (orderlist.isEmpty()) {
            System.out.println("Order List is empty!! Let's wait for orders");
            return null;
        }

        // if list size = 1
        if (orderlist.size() == 1) {
            Order order = orderlist.values().iterator().next();
            System.out.println(order.getFoodType() + " Order Ready!");
            orderlist.remove(1);
            return order;
        }

        //  if size>1 , look for fish first then chicken and then lamb
        for (String foodType : new String[]{"fish", "chicken", "lamb"}) {
            orderlist.values().removeIf(order -> order.getFoodType().equals(foodType));
            System.out.println(foodType + " Order Ready!");
        }


        return null;
    }
//        // if size>1 , look for fish first then chicken and then lamb
//        for (Order order : orderlist.values()) {
//            if (order.getFoodType().equals("fish") || order.getFoodType().equals("chicken")) {
//                int orderKey = 0;
//                System.out.println(order.getFoodType() + " Order Ready!");
//                for (int key : orderlist.keySet()) {
//                    if (orderlist.get(key) == order) {
//                        orderKey = key;
//                        break;
//                    }
//                }
//                orderlist.remove(orderKey);
//                return order;
//            }
//        }
//        return null;
//    }

    //        for (String foodType : new String[]{"fish", "chicken", "lamb"}) {
//            for (Map.Entry<Integer, Order> entry : orderlist.entrySet()) {
//                Order order = entry.getValue();
//                if (order.getFoodType().equals(foodType)) {
//                    System.out.println(order.getFoodType() + " Order Ready!");
//                    orderlist.remove(entry.getKey());
//                }
//            }
//        }

    public static void takeOrder(Order order) {
        orderlist.put(key,order);
        key++;
    }
}




