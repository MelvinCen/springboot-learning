package cn.melvin.exception;

public class CustomException extends RuntimeException {

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code,String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
