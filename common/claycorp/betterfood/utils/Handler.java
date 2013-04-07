package claycorp.betterfood.utils;

import claycorp.betterfood.utils.Registry;

public class Handler {
    public static void log(Object s) {
        System.out.println(s);
    }

    public static void logName(String s) {
        System.out.println(Registry.name + " " + s);
    }
}