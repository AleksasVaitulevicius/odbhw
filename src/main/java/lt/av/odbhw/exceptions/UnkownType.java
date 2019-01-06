package lt.av.odbhw.exceptions;


public class UnkownType extends RuntimeException {

    public UnkownType(String type) {
        super("Type " + type + " is unknown.");
    }

}


