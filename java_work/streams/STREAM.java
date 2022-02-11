package streams;

import java.util.List;
import java.util.stream.Collectors;
public class STREAM {
    public static void main(String[] args) {
        List<Person> people=List.of(
            new Person("Jhon",Gender.Male),
            new Person("Maria",Gender.Female),
            new Person("Kend",Gender.Male),
            new Person("Alice",Gender.Female),
            new Person("Arpan",Gender.Male),
            new Person("ganga",Gender.prefer_not_to_say)
        );
        List<Gender>G=people.stream()
            .map(person->person.gender).collect(Collectors.toList());
        G.forEach(System.out::println);
        System.out.println("\n");
        List<String>G1=people.stream()
            .map(person->person.name).collect(Collectors.toList());
        G1.forEach(System.out::println);
        System.out.println("\n");
        people.stream()
            .map(person->person.name)
                .map(String::length).forEach(System.out::println);
        boolean containsAllFemale=people.stream().allMatch(person->person.gender.equals(Gender.Female));
        boolean containsFemale=people.stream().anyMatch(person->person.gender.equals(Gender.prefer_not_to_say));
        System.out.println(containsAllFemale+" "+containsFemale);
        people.stream().filter(person->person.gender.equals(Gender.Female)).forEach(System.out::println);
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
        Male,Female,prefer_not_to_say
    }
}
