package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;
import java.util.Collections;
public class HOMEWORK {
    public static void main(String[] args) {
        // List<List<Integer>> l1=List.of(List.of(1,3,4,2,7,8,3,6,9),List.of(3,5,7,13,52,3,7,9,0,15,6));
        // l1.stream().flatMap(p->p.stream()).distinct().sorted().forEach(System.out::println);
        // List<String> s=List.of("Arpan","rAhul","sataBda");
        List<Integer> i1=List.of(1,2,6,4,-4,3),i2=List.of(4,5,-6,-1,-2);
        
        // s.stream().map(names->names.toUpperCase())
        //     .flatMap(p->Arrays.stream(p.split("")))
        //         .distinct().forEach(System.out::println);

        // s.stream().map(name->name.toLowerCase())
        //     .map(name->name.split("")).flatMap(l->Arrays.stream(l))
        //         .distinct().forEach(System.out::println);
    
        // i1.stream()
        //     .flatMap(i->i2.stream()
        //         .map(k->new PAIR(i,k)))
        //             .distinct().filter(k->k.first==k.second*k.second).forEach(System.out::println);
        // i1.stream()
        //     .flatMap(i->i2.stream()
        //         .map(k->new PAIR(i*i,k*k)))
        //             .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        //                 .entrySet()
        //                     .stream()
        //                         .filter(m -> m.getValue() > 1).forEach(System.out::println);
        List<PAIR> list=i1.stream()
            .flatMap(i->i2.stream()
                .map(k->new PAIR(i*i,k*k)))
                    .collect(Collectors.toList());
        list.stream()
                .filter(i -> Collections.frequency(list, i) > 1).forEach(System.out::println);
    }
    static class PAIR{
        private final int first;
        private final int second;
        PAIR(int a,int b){
            this.first=a;
            this.second=b;
        }
        @Override
        public boolean equals(Object p){
            if(this==p)return true;
            if(p==null)return false;
            if(!(p instanceof PAIR))return false;
            PAIR temp=(PAIR)p;
            return (first==temp.first&&second==temp.second)||(first==temp.second&&second==temp.first);
        }
        @Override
        public String toString(){
            return first+","+second;
        }
    }
}
