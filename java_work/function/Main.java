package function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        //function takes 1  argument and return one
        int i=incrementByOne(0);
        System.out.println(i);

        i=increamentByOneFunction.apply(1);
        System.out.println(i);

        Function<Integer,Integer>incrementbyOneThenMultiplyBy10Function
            =increamentByOneFunction.andThen(multiplyBy10Function);
        i=incrementbyOneThenMultiplyBy10Function.apply(4);
        System.out.println(i);
        //bifunction takes 2 argument and return one
        System.out.println("using normal function: "+incrementByOneThenMultiply(7,8));
        System.out.println("using Bifunction: "+incrementByOneThenMultiplyFunction.apply(7, 8));

    }
    static Function<Integer,Integer> increamentByOneFunction=number->number+1;
    static Function<Integer,Integer> multiplyBy10Function=number->number*10;
    static int incrementByOne(int number){
        return number+1;
    }
    static int incrementByOneThenMultiply(int number,int mul){
        return (number+1)*mul;
    }
    static BiFunction<Integer,Integer,Integer> incrementByOneThenMultiplyFunction=
        (numberToIncrement,NumberToMultiply)->(numberToIncrement+1)*NumberToMultiply;
}
