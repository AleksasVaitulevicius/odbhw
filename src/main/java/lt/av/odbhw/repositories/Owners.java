package lt.av.odbhw.repositories;

import lt.av.odbhw.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;

public class Owners {

    private final EntityManager entityManager;

    public Owners(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Owner owner) {
        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.getTransaction().commit();
    }

    public Owner get(Long id) {
        return entityManager.createQuery( "SELECT owner FROM Owner owner WHERE owner.id = :id", Owner.class)
            .setParameter("id", id)
            .getSingleResult();
    }

    public List<Owner> get() {
        return entityManager.createQuery("SELECT owner FROM Owner owner", Owner.class).getResultList();
    }

    public Owner get(String name) {
        return entityManager.createQuery("SELECT owner FROM Owner owner WHERE owner.name = :name", Owner.class)
            .setParameter("name", name)
            .getSingleResult();
    }

    public Owner getByPet(Long id) {
        return entityManager
            .createQuery(
                "SELECT owner FROM Owner owner JOIN owner.pets pet WHERE pet.id = :id",
                Owner.class
            )
            .setParameter("id", id)
            .getSingleResult();
    }

    public void put(Owner owner) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Owner owner WHERE owner.id = :id")
            .setParameter("id", owner.getId())
            .executeUpdate();
        System.out.println(owner);
        entityManager.persist(owner);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Owner owner = get(id);
        entityManager.remove(owner);
        entityManager.getTransaction().commit();
    }

}


