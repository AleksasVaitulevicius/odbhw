package lt.av.odbhw.controllers;

import lt.av.odbhw.entities.Owner;
import lt.av.odbhw.exceptions.CommandNotFound;
import lt.av.odbhw.exceptions.WrongNumberOfParams;
import lt.av.odbhw.repositories.Owners;

import java.util.ArrayList;
import java.util.List;

public class OwnerController extends Controller {

    private final Owners owners;

    public OwnerController(Owners owners) {
        this.owners = owners;
    }

    protected void add(List<String> params) {
        if (params.size() == 0) {
            throw new WrongNumberOfParams("add", params.size());
        }
        String name = params.get(0);
        Owner owner = Owner.builder()
            .name(name)
            .pets(new ArrayList<>())
            .build();
        owners.add(owner);
    }

    protected void get(List<String> params) {
        if (params.size() == 0) {
            owners.get().forEach(System.out::println);
            return;
        }
        switch(params.get(0)) {
            case "id":
                System.out.println(owners.get(toLong(params.get(1))));
                return;
            case "name":
                System.out.println(owners.get(params.get(1)));
                return;
            case "of_pet":
                System.out.println(owners.getByPet(toLong(params.get(1))));
                return;
            default:
                throw new CommandNotFound("get " + params.get(0));
        }
    }

    protected void put(List<String> params) {
        Long id = Long.parseLong(params.get(0));
        String name = params.get(1);
        Owner owner = Owner.builder()
            .id(id)
            .name(name)
            .pets(new ArrayList<>())
            .build();
        owners.put(owner);
    }

    protected void delete(List<String> params) {
        if (params.size() == 0) {
            throw new WrongNumberOfParams("delete", params.size());
        }
        String idString = params.get(0);
        Long id = Long.parseLong(idString);
        owners.delete(id);
    }

}


