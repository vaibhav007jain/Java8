package main.java.com.practice.java8;

import main.java.com.practice.entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeJava8 {

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        String phone = "7588589353";
        String formatted = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        System.out.println(formatted);

        // Count males & females in the list
        System.out.println("\n\nGender wise grouping By:");
        Map<String, Long> group = getUsers().stream().collect(Collectors.groupingBy(User::getGender, Collectors.counting()));
        group.forEach((k, v) -> System.out.println("Gender: " + k + " Count: " + v));

        // Sort based on salary
        sortOnSalary();
        // Count characters
        String input = "this is a sample input string";
        countCharacters(input);
        calculateAverageAge();
        System.out.println(getMales());
        System.out.println(getAdultMales());
        System.out.println(getAdultMalesSortedOnSalary());
        System.out.println(getAdultMalesSortedOnSalaryThenOnAge());

        //Converting List to Map
        Map<Long, Double> idVsSalaryMap = getAMapOfIdAndSalary();
        idVsSalaryMap.forEach((k, v) -> System.out.println("Id: " + k + " Salary: " + v));
        Map<Long, Double> sortedBasedOnIds = sortBasedOnSalary();
        sortedBasedOnIds.forEach((k, v) -> System.out.println("Id: " + k + " Salary: " + v));

        getUniqueBooks().stream().forEach(System.out::println);
        System.out.println("Factorial: " + getFactorialOf(5));

        System.out.println(findFrequencyOfCharsInAString("password@123"));
    }

    private static String findFrequencyOfCharsInAString(String string) {
        string.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toMap(x -> x, v -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n) -> n, HashMap::new))
                .forEach((k, v) -> System.out.println("Char: " + k + " Count: " + v));
// OR
        string.chars()
                .boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum
                )).forEach((k, v) -> System.out.println("Char: "+k+" New Count: "+v));

        string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println("Grouped by Key: "+k+" And Value: "+v));

        return null;
    }

    private static int getFactorialOf(int number) {
        return IntStream.rangeClosed(1, number).reduce(1, (x, y) -> x * y);
    }

    private static List<String> getUniqueBooks() {
        System.out.println("\n\nList of unique books using flatMap:");
//        return getUsers().stream().map(User::getBooks).flatMap(x->x.stream()).filter(book -> "Rich Dad Poor Dad".equalsIgnoreCase(book)).collect(Collectors.toList());
        return getUsers().stream().map(User::getBooks).flatMap(x -> x.stream()).distinct().collect(Collectors.toList());

//        OR
//        return  getUsers().stream().map(user -> user.getBooks()).flatMap(book -> book.stream()).collect(Collectors.toList());
    }

    private static Map<Long, Double> sortBasedOnSalary() {
        System.out.println("\n\nMap of Sorted Salary & Id:");
        return getUsers()
                .stream()
                .collect(Collectors.toMap(User::getId, User::getSalary))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));

//        return getUsers().stream().sorted(Comparator.comparing(User::getSalary)).collect(Collectors.toMap(User::getId, User::getSalary, (o,n) -> o, LinkedHashMap::new));
    }

    private static Map<Long, Double> getAMapOfIdAndSalary() {
        System.out.println("\n\nMap of Id & Salary:");
        return getUsers().stream().collect(Collectors.toMap(User::getId, User::getSalary, (oldValue, newValue) -> newValue));
    }

    private static List<User> getAdultMalesSortedOnSalaryThenOnAge() {
        System.out.println("\n\nAdult Male Sorted On Salaries & Then Age :");
        return getAdultMales().stream().sorted(Comparator.comparing(User::getSalary).thenComparing(User::getAge)).collect(Collectors.toList());
    }

    private static List<User> getAdultMalesSortedOnSalary() {
        System.out.println("\n\nAdult Male Sorted On Salaries Users:");
        getAdultMales().stream().sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                }
                return 0;
            }
        }).collect((Collectors.toList()));

        getUsers().stream().filter(adultMalePredicate()).sorted(Comparator.comparing(User::getSalary)).collect(Collectors.toList());

        return getAdultMales().stream().sorted(Comparator.comparing(User::getSalary)).collect(Collectors.toList());

    }

    private static List<User> getAdultMales() {
        System.out.println("\n\nAdult Male Users:");
        return getUsers().stream().filter(adultMalePredicate()).collect(Collectors.toList());
    }

    private static Predicate<User> adultMalePredicate() {
        return user -> "male".equalsIgnoreCase(user.getGender()) && 18 <= user.getAge();
    }

    private static List<User> getMales() {
        System.out.println("\n\nAll Male Users:");
        return getUsers().stream().filter(user -> "male".equalsIgnoreCase(user.getGender())).collect(Collectors.toList());

//        return getUsers().stream().filter(user -> user.getGender().equalsIgnoreCase("male")).collect(Collectors.toList());
    }

    private static void calculateAverageAge() {
        int sumAge = getUsers().stream().map(User::getAge).reduce(0, Math::addExact);
        Integer reduce = getUsers().stream().map(User::getAge).reduce(0, (a, b) -> a + b);
        System.out.println("\n\nAverage Age = " + sumAge / getUsers().size());
        System.out.println("Average Age Other method= " + reduce / getUsers().size());

//        float avg = getUsers().stream().map(User::getAge).reduce(0, Integer::sum)/getUsers().size();
    }

    private static void countCharacters(String input) {
//        input.chars().peek(System.out::println).collect(Collectors.groupingBy(Integer::getInteger, Collectors.counting()));
        System.out.println(input.chars().distinct().count());
//        input.chars().boxed().count();
    }

    private static void sortOnSalary() {
        System.out.println("\n\nSorted based on salary:");
        getUsers().stream().sorted(Comparator.comparing(User::getSalary)).forEach(System.out::println);

        getUsers().stream().sorted(Comparator.comparing(User::getSalary));
    }


    private static List<User> getUsers() {
        if (users.isEmpty()) {
            List<String> book1 = new ArrayList<>();
            book1.add("Who Moved my Cheese");
            book1.add("The Alchemist");
            book1.add("2 States");
            book1.add("Rich Dad Poor Dad");

            List<String> book2 = new ArrayList<>();
            book2.add("Who Moved my Cheese");
            book2.add("The Intelligent Investor");
            book2.add("Five Point Someone");
            book2.add("The Stars Shine Down");

            User aamir = new User(1, "Aamir", 53, 10000, "male");
            User salman = new User(3, "Salman", 53, 30000, "male");
            aamir.setBooks(book1);
            salman.setBooks(book2);
            users.add(aamir);
            users.add(new User(2, "Shahrukh", 54, 20000, "male"));
            users.add(salman);
            users.add(new User(17, "Varun", 32, 30000, "male"));
            users.add(new User(18, "Shahid", 40, 30000, "male"));
            users.add(new User(4, "Hritik", 45, 40000, "male"));
            users.add(new User(5, "Ranveer", 35, 50000, "male"));
            users.add(new User(6, "Ranbir", 32, 60000, "male"));
            users.add(new User(7, "Saif", 49, 70000, "male"));
            users.add(new User(8, "Taimur", 3, 1000, "male"));
            users.add(new User(9, "Soha", 40, 25000, "female"));
            users.add(new User(10, "Kareena", 39, 100000, "female"));
            users.add(new User(11, "Aishwarya", 38, 200000, "female"));
            users.add(new User(12, "Hridhan", 12, 5000, "male"));
            users.add(new User(13, "Sara", 19, 11000, "female"));
            users.add(new User(19, "Deepika", 35, 11000, "female"));
            users.add(new User(20, "Priyanka", 35, 11000, "female"));
            users.add(new User(14, "Aradhya", 7, 9000, "female"));
            users.add(new User(15, "Amitabh", 75, 500000, "male"));
            users.add(new User(16, "Alia", 21, 700000, "female"));
        }
        return users;
    }
}
