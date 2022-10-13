package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .forEach(val -> System.out.println(val)
                );
        System.out.println("=========================================");

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(val -> System.out.println(val)
                );
        System.out.println("=========================================");

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(val -> System.out.println(val));
        System.out.println("=========================================");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .ifPresentOrElse(val -> System.out.println(val), () -> System.out.println(-1));
        System.out.println("=========================================");

        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(val -> System.out.println(val));
        System.out.println("=========================================");

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream()
                        .anyMatch(number -> number == user.getId()))
                .map(userInfo -> userInfo.getFirstName())
                .forEach(val -> System.out.println(val));
        System.out.println("=========================================");
    }

}
