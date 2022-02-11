import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class item {
    private String name;
    private double rate;
    private long code;
    private int quantity;
    public item() {
        this.name = "";
        this.rate = 0;
        this.code = 0;
        this.quantity = 0;
    }
    public item(String name, double rate, long code, int quantity) {
        this.name = name;
        this.rate = rate;
        this.code = code;
        this.quantity = quantity;
    }
    public item(item Item) {
        this.name = Item.name;
        this.rate = Item.rate;
        this.code = Item.code;
        this.quantity = Item.quantity;

    }
    public String toString() {
        String item_code=(name.substring(0,3)).concat(Integer.toString(quantity));
        System.out.println("item_code: "+item_code);
        return "Item [name=" + name + ", rate=" + rate + ", code=" + code
                + ", quantity=" + quantity + ", item_code=" + item_code + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Itemlist {
    private ArrayList<item> List;
    private Scanner sc = new Scanner(System.in);
    public Itemlist() {
        System.out.println("New Shop for Items created.");
        List = new ArrayList<item>();
    }
    public int getSize() {
        return List.size();

    }
    private item search(long code) {
        Iterator<item> itr = List.iterator();
        item Item;
        while (itr.hasNext()) {
            Item = new item(itr.next());
            if (Item.getCode() == code) {
                return Item;
            }
        }
        return null;
    }
    public item search(String name) {
        Iterator<item> itr = List.iterator();
        item Item;
        while (itr.hasNext()) {
            Item = new item(itr.next());
            if (Item.getName() == name) {
                return Item;
            }
        }
        return null;
    }
    public void addItem() {
        long aCode;
        String aName;
        double aRate;
        int aQuantity;
        item foundItem;

        System.out.println("Enter Item code: ");
        aCode = sc.nextLong();
        foundItem = search(aCode);
        if (foundItem == null) {
            System.out.println("Item name : ");
            aName = sc.next();
            System.out.println("Rate : ");
            aRate = sc.nextDouble();
            System.out.println("Quantity : ");
            aQuantity = sc.nextInt();
            item aItem = new item(aName, aRate, aCode, aQuantity);
            List.add(aItem);
        } else if (foundItem != null) {
            System.out.println("Item exists");
        }

    }
    public void updateStock(int t) {
        int choice, quantity;
        long code;
        double price;
        item foundItem;
        if(t==1) {
            System.out.println("1. Update quantity.");
            System.out.println("2. Update rate.");
            System.out.print("Choice:");
            choice = sc.nextInt();
        }else{
            choice=1;
        }
        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        if (choice == 1) {

            System.out.println("Enter quantity to add: ");
            quantity = sc.nextInt();
            foundItem.setQuantity(foundItem.getQuantity() + quantity);
            System.out.println("\n Quantity updated\n");
            System.out.println("Present quantity: " + foundItem.getQuantity());
        }

        else if (choice == 2) {

            System.out.println("Enter new price: ");
            price = sc.nextDouble();
            foundItem.setRate(price);
            System.out.println("\n Price updated\n");
            System.out.println("Present Price: " + foundItem.getRate());
        }

        else {
            System.out.println("Wrong choice!!");
            updateStock(2);
        }

    }
    public void display() {

        long code;
        item foundItem;

        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        System.out.println(foundItem.toString());
    }
    public void issueItem() {
        int numberOfItem;
        long code;
        item foundItem;

        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        System.out.println("Number of Item : ");
        numberOfItem = sc.nextInt();
        if (numberOfItem > foundItem.getQuantity()) {
            System.out.println("\nRequired number of Items not in stock\n\n");
            return;
        }

        else {
            System.out.println("\nCost of " + numberOfItem + " copies : rs. "
                    + numberOfItem * foundItem.getRate());
            foundItem.setQuantity(foundItem.getQuantity() - numberOfItem);
        }
    }
    public double checkPrice(long code) {
        item foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return 0.0;
        }

        else
            return foundItem.getRate();
    }
}


class Arpan {
    public static void main(String[] args) {
        long code;
        char choice;
        Itemlist aShop = new Itemlist();
        Scanner sc = new Scanner(System.in);
        int type;
        System.out.print("1. If you are a SEO user\n2. If you are a SK user\nChoice: ");
        type = sc.nextInt();
        System.out.println("-----ITEM------");
        do {
            if(type==1) {
                System.out.println("1. Add items to list");
                System.out.println("2. Update item list");
                System.out.println("3. Issue item");
                System.out.println("4. Display item details");
                System.out.println("5. Check price for a item");
                System.out.println("6. Exit");
                System.out.print("Choice:");
                choice = sc.next().charAt(0);
                switch (choice) {
                    case '1':
                        aShop.addItem();
                        break;
                    case '2':
                        aShop.updateStock(1);
                        break;
                    case '3':
                        aShop.issueItem();
                        break;
                    case '4':
                        aShop.display();
                        break;
                    case '5':
                        System.out.println("Price of the Item is:"
                                + aShop.checkPrice(inputCode()));
                    case '6':
                        System.out.println("Thank you!\n");
                        System.exit(0);
                        break;
                }
            }
            else if(type==2){
                    System.out.println("1. Add items to list");
                    System.out.println("2. Update quantity");
                    System.out.println("3. Issue item");
                    System.out.println("4. Display item details");
                    System.out.println("5. Check price for a item");
                    System.out.println("6. Exit");
                    System.out.print("Choice:");
                    choice = sc.next().charAt(0);
                    switch (choice) {
                        case '1':
                            aShop.addItem();
                            break;
                        case '2':
                            aShop.updateStock(2);
                            break;
                        case '3':
                            aShop.issueItem();
                            break;
                        case '4':
                            aShop.display();
                            break;
                        case '5':
                            System.out.println("Price of the Item is:"+ aShop.checkPrice(inputCode()));
                            break;
                        case '6':
                            System.out.println("Thank you!\n");
                            System.exit(0);
                            break;
                    }
            }
        } while (true);
    }
        public static long inputCode() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Item code:");
            if (sc.hasNextLong()) {
                return sc.nextLong();
            } else {
                System.out.println("Invalid Input");
                return 0;
            }

        }
}