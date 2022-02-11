package imperative;

import java.util.*;
import java.util.stream.Collectors;
public class Main{
    public static void main(String args[]){
        List<Person> people=List.of(
            new Person("Jhon",Gender.Male),
            new Person("Maria",Gender.Female),
            new Person("Kend",Gender.Male),
            new Person("Alice",Gender.Female),
            new Person("Arpan",Gender.Male)
        );
        //imperative approach
        System.out.println("imperative approach");
        List<Person> females=new ArrayList<Person>();
        for(Person person:people){
            if((Gender.Female).equals(person.gender))
                females.add(person);
        }
        for(Person female:females){
            System.out.println(female);
        }
        //declarative approach
        System.out.println("declarative approach");
        people.stream()
            .filter(person->person.gender.equals(Gender.Female))
                .collect(Collectors.toList())
                    .forEach(System.out::println);
        // people.stream().filter(person->person.gender.equals(Gender.Female)).forEach(System.out::println);
        List<Person> female2=people.stream()
            .filter(person->person.gender.equals(Gender.Female))
                .collect(Collectors.toList());
        for(Person female:female2)
            System.out.println(female);
    }
    static class Person{
        private final String name;
        private final Gender gender;
        Person(String name,Gender gender){
            this.name=name;
            this.gender=gender;
        }
    @Override
    public String toString(){
        return "person{"+"name="+name+"\tgender="+gender+'}';
    }
    }
    enum Gender{
        Male,Female
    }
}