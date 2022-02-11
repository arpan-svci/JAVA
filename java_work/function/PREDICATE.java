package function;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PREDICATE {
    public static void main(String[] args) {
        System.out.println("By normal function:");
        System.out.println("is  phone number +919064713044 valid?: "+isPhoneNumberValid("+919064713044"));
        System.out.println("is  phone number +919064713044 valid?: "+isPhoneNumberValid("90456782345"));
        System.out.println("By predicate:");
        System.out.println("is  phone number +919064713044 valid?: "+isPhoneNumberValidPredicate.test("+919064713044"));
        System.out.println("is  phone number +919064713044 valid?: "+isPhoneNumberValidPredicate.test("90456782345"));
        System.out.println("is phone number +919064714044 valid and contains three?"
            +isPhoneNumberValidPredicate.and(contains3Predicate).test("+919064714044"));
        System.out.println("is phone number contains the literal?: "
            +isphoheNumberContainsSpecifiedCharacter.test("+919064713044","9064"));
    }
    static Predicate<String> isPhoneNumberValidPredicate=phoneNumber->phoneNumber.startsWith("+91")&&phoneNumber.length()==13;
    static BiPredicate<String,String> isphoheNumberContainsSpecifiedCharacter
        =(phonenumber,literal)->phonenumber.contains(literal);
    static Predicate<String> contains3Predicate=phonenumber->phonenumber.contains("3");
    static boolean isPhoneNumberValid(String PhoneNumber){
        return PhoneNumber.startsWith("+91")&&PhoneNumber.length()==13;
    }
}
