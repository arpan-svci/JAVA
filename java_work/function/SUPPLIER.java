package function;

import java.util.function.Supplier;

public class SUPPLIER {
    public static void main(String[] args) {
        System.out.println(getConnectionUrl());
        System.out.println(getConnectionUrlSupplier.get());
    }
    static String getConnectionUrl(){
        return "http://localhost:80/user";
    }
    static Supplier<String>getConnectionUrlSupplier=()
        ->"http://localhost:80/user"; //it can return any type of class datatype,function etc
}
