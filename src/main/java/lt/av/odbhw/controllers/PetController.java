package lt.av.odbhw.controllers;

import lt.av.odbhw.entities.Dog;
import lt.av.odbhw.entities.Owner;
import lt.av.odbhw.entities.Pet;
import lt.av.odbhw.entities.Snake;
import lt.av.odbhw.exceptions.UnkownType;
import lt.av.odbhw.exceptions.WrongNumberOfParams;
import lt.av.odbhw.repositories.Owners;
import lt.av.odbhw.repositories.Pets;

import java.util.ArrayList;
import java.util.List;

public class PetController extends Controller {

    private final Pets pets;
    private final Owners owners;

    public PetController(Pets pets, Owners owners) {
        this.pets = pets;
        this.owners = owners;
        commands.put("dogs", params -> dogs());
        commands.put("snakes", params -> snakes());
    }


    protected void add(List<String> params) {
        if (params.size() < 4) {
            throw new WrongNumberOfParams("add", params.size());
        }
        String type = params.get(0);
        String name = params.get(1);
        String ownerIdString = params.get(3);
        Long ownerId = Long.parseLong(ownerIdString);
        Owner owner = owners.get(ownerId);
        Pet pet;
        switch (type) {
            case "dog":
                Integer timesFetchedStick = Integer.parseInt(params.get(2));
                pet = Dog.builder().name(name).timesFetchedStick(timesFetchedStick).owner(owner).build();
                break;
            case "snake":
                Boolean isSkinShedding = !params.get(2).equals("0");
                pet = Snake.builder().name(name).isSkinShedding(isSkinShedding).owner(owner).build();
                break;
            default:
                throw new UnkownType(type);
        }
        if (owner.getPets() == null) {
            owner.setPets(new ArrayList<>());
        }
        owner.getPets().add(pet);
        pets.add(pet);
    }

    protected void get(List<String> params) {
        if (params.size() == 0) {
            pets.get().forEach(System.out::println);
            return;
        }
        String name = params.get(0);
        Pet owner;
        try {
            Long id = Long.parseLong(name);
            owner = pets.get(id);
        }
        catch (NumberFormatException ignored) {
            owner = pets.get(name);
        }
        System.out.println(owner);
    }

    private void dogs() {
        List<Dog> dogs = pets.dogs();
        System.out.println(dogs);
    }

    private void snakes() {
        List<Snake> snakes = pets.snakes();
        System.out.println(snakes);
    }

    protected void put(List<String> params) {
        if (params.size() < 3) {
            throw new WrongNumberOfParams("put", params.size());
        }
        Long id = Long.parseLong(params.get(0));
        String name = params.get(1);
        String additionalParam = params.get(2);
        pets.put(id, name, additionalParam);
    }

    protected void delete(List<String> params) {
        if (params.size() == 0) {
            throw new WrongNumberOfParams("delete", params.size());
        }
        String idString = params.get(0);
        Long id = Long.parseLong(idString);
        pets.delete(id);
    }

}


