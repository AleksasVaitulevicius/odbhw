package lt.av.odbhw.exceptions;


public class CommandNotFound extends RuntimeException {

    public CommandNotFound(String command) {
        super("Command " + command + " not found");
    }

}


