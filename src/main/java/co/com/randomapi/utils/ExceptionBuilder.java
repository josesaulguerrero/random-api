package co.com.randomapi.utils;

public class ExceptionBuilder {
    public static<K extends Exception> K buildException(Class<K> exceptionClass, String message) {
        try {
            return exceptionClass
                    .getDeclaredConstructor(String.class)
                    .newInstance(message);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
