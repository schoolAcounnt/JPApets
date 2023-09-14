package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.petList;

public class ListpetHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("PetsJPA");
	
	public void insertItem(petList li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<petList> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<petList> allItems = em.createQuery("SELECT i from petList i").getResultList();
		return allItems;
		
	}

	public void deleteItem(petList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<petList> typedQuery = em.createQuery("select pl from petList pl where pl.type = :selectedType and pl.name = :selectedPet", petList.class);
		
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedPet", toDelete.getName());

		
		typedQuery.setMaxResults(1);
		
		petList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public petList searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		petList found = em.find(petList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(petList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<petList> searchForPetByType(String pettype) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<petList> typedQuery = em.createQuery("select pl from petList pl where pl.type = :selectedType", petList.class);
		
		typedQuery.setParameter("selectedType", pettype);
		
		List<petList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<petList> searchForpetbyname(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<petList> typedQuery = em.createQuery("select pl from petList pl where pl.name = :selectedName", petList.class);
		
		typedQuery.setParameter("selectedName", petName);
		
		List<petList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	}