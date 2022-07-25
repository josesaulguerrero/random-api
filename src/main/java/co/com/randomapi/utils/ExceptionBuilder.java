package co.com.randomapi.utils;

public class ExceptionBuilder {
    private Class<? extends RuntimeException> exceptionClass;
    private String developerMessage = "No message was supplied...";

    public<K extends RuntimeException> ExceptionBuilder(Class<K> exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public ExceptionBuilder developerMessage(String message) {
        this.developerMessage = message;
        return this;
    }

    public RuntimeException build() {
        return getExceptionInstance();
    }

    private RuntimeException getExceptionInstance() {
        try {
            return this.exceptionClass.getDeclaredConstructor(String.class).newInstance(this.developerMessage);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
