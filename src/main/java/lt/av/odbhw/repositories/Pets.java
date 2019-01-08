package lt.av.odbhw.repositories;

import lt.av.odbhw.entities.Dog;
import lt.av.odbhw.entities.Pet;
import lt.av.odbhw.entities.Snake;

import javax.persistence.EntityManager;
import java.util.List;

public class Pets {

    private final EntityManager entityManager;

    public Pets(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Pet pet) {
        entityManager.getTransaction().begin();
        entityManager.persist(pet);
        entityManager.getTransaction().commit();
    }

    public Pet get(Long id) {
        return entityManager.createQuery("SELECT pet FROM Pet pet WHERE pet.id = :id", Pet.class)
            .setParameter("id", id)
            .getSingleResult();
    }

    public Pet get(String name) {
        return entityManager.createQuery("SELECT pet FROM Pet pet WHERE pet.name = :name", Pet.class)
            .setParameter("name", name)
            .getSingleResult();
    }

    public List<Pet> get() {
        return entityManager.createQuery("SELECT pet FROM Pet pet", Pet.class).getResultList();
    }

    public List<Pet> getByOwner(Long id) {
        return entityManager
            .createQuery("SELECT pet FROM Pet pet WHERE pet.owner.id = :id", Pet.class)
            .setParameter("id", id)
            .getResultList();
    }

    public List<Dog> dogs() {
        return entityManager.createQuery("SELECT pet FROM Dog pet", Dog.class).getResultList();
    }

    public List<Snake> snakes() {
        return entityManager.createQuery("SELECT pet FROM Snake pet", Snake.class).getResultList();
    }

    public void put(Long id, String name, String additionalParam) {
        boolean isDog = get(id) instanceof Dog;
        if (isDog) {
            put(Dog.builder().id(id).name(name).timesFetchedStick(Integer.parseInt(additionalParam)).build());
        }
        else {
            put(Snake.builder().id(id).name(name).isSkinShedding(!additionalParam.equals("0")).build());
        }
    }

    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Pet pet = get(id);
        entityManager.remove(pet);
        entityManager.getTransaction().commit();
    }

    private void put(Pet pet) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Pet pet WHERE pet.id = :id")
            .setParameter("id", pet.getId())
            .executeUpdate();
        entityManager.persist(pet);
        entityManager.getTransaction().commit();
    }

}


