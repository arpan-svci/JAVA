package function;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
public class CONSUMER {
    public static void main(String[] args) {
        Customer n= new Customer("Maria", "9064713044");
        greet(n);
        greetCustomerConsumerFunction.accept(n);
        greetCustomerConsumerByFunctionv2.accept(n,true);
    }
    static BiConsumer<Customer,Boolean>greetCustomerConsumerByFunctionv2=(customer,showphoneNumber)->
        System.out.println("By biConsumer: "+"Hello "+customer.CustomerName+" ,thanks for registering phone number "
        +(showphoneNumber? customer.CustomerPhoneNumber:"**********"));

    static Consumer<Customer> greetCustomerConsumerFunction=customer->System.out.println("By Consumer: "+
        "Hello "+customer.CustomerName+", thanks for registering phone number "+customer.CustomerPhoneNumber);

    static void greet(Customer customer){
        System.out.println("By Normal Function: "+"Hello "+customer.CustomerName+", thanks for registering phone number "+customer.CustomerPhoneNumber);
    }

    static class Customer{
        private final String CustomerName;
        private final String CustomerPhoneNumber;
        Customer(String name,String phoneNumber){
            this.CustomerName=name;
            this.CustomerPhoneNumber=phoneNumber;
        }
    }
}
