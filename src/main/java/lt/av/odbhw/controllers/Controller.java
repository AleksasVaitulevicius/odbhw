package lt.av.odbhw.controllers;

import lt.av.odbhw.exceptions.CommandNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class Controller {

    private Map<String, Consumer<List<String>>> commands;

    Controller() {
        commands = new HashMap<>();
        commands.put("add", this::add);
        commands.put("get", this::get);
        commands.put("put", this::put);
        commands.put("delete", this::delete);
    }

    public void execute(String command, List<String> params) {
        Consumer<List<String>> function = commands.get(command);
        if (function == null) {
            throw new CommandNotFound(command);
        }
        function.accept(params);
    }

    protected abstract void add(List<String> params);

    protected abstract void get(List<String> params);

    protected abstract void put(List<String> params);

    protected abstract void delete(List<String> params);

    Long toLong(String idString) {
        try {
            return Long.parseLong(idString);
        }
        catch (NumberFormatException ignored) {
            throw new CommandNotFound("get id <string>");
        }
    }

}




