package lt.av.odbhw.exceptions;


public class WrongNumberOfParams extends RuntimeException {

    public WrongNumberOfParams(String command, Integer paramsNumber) {
        super("Command " + command + " requires more than " + paramsNumber + " params");
    }

}


