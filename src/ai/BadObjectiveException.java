package ai;
public class BadObjectiveException extends Exception {

    /**
    * This exception is for AI instances and is to be thrown
    * when the objective is already met.
    */
	private static final long serialVersionUID = 2148680020600207295L;
	private String message;

    public BadObjectiveException() {
    }

    public BadObjectiveException(String msg) {
        message = msg;
    }

    public String getMsg() {
        return message;
    }
}
