package lt.av.odbhw.controllers;

import lt.av.odbhw.entities.Dog;
import lt.av.odbhw.entities.Owner;
import lt.av.odbhw.entities.Pet;
import lt.av.odbhw.entities.Snake;
import lt.av.odbhw.exceptions.CommandNotFound;
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
        switch(params.get(0)) {
            case "dogs":
                System.out.println(pets.dogs());
                return;
            case "snakes":
                System.out.println(pets.snakes());
                return;
            case "id":
                System.out.println(pets.get(toLong(params.get(1))));
                return;
            case "name":
                System.out.println(pets.get(params.get(1)));
                return;
            case "of_owner":
                pets.getByOwner(toLong(params.get(1))).forEach(System.out::println);
                return;
            default:
                throw new CommandNotFound("get " + params.get(0));
        }
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


