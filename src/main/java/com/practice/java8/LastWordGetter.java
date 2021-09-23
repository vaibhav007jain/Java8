package main.java.com.practice.java8;

public class LastWordGetter {

    public static void main(String[] args) {
        String input = "I wish you a bug-free day";
        System.out.println("Using split: " + getLastWordUsingSplit(input));

        System.out.println("Using subString: " + getLastWordUsingSubString(input));
    }

public String getLastWordUsingSubString(String input) {
    return input.substring(input.lastIndexOf(" ") + 1);
}

    private static String getLastWordUsingSplit(String input) {
        String[] tokens = input.split(" ");
        return tokens[tokens.length - 1];
    }
}
