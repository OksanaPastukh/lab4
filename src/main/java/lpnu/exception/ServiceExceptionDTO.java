package lpnu.exception;

public class ServiceExceptionDTO {
    private int code;
    private String message;


    public ServiceExceptionDTO() {
    }

    public ServiceExceptionDTO(final ServiceException ex) {
        this.code = ex.getCode();
        this.message = ex.getMessage();
    }
    public ServiceExceptionDTO(final int code, final String message) {
        this.code = code;
        this.message = message;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
