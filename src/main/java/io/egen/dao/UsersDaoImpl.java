package io.egen.dao;

import io.egen.entity.Users;

import java.util.List;

//import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Users findUserById(String id) {
		Users user = em.find(Users.class, id);
		return user;
	}

	@Override
	public Users findUserByEmailId(String email) {
		TypedQuery<Users> qlString = em.createNamedQuery("Users.findUserByEmailId", Users.class);
		qlString.setParameter("email", email);
		List<Users> user = qlString.getResultList();

		if (user != null && user.size() == 1) {
			return user.get(0);

		} else {
			return null;
		}
	}
	
	@Override
	public Users findUserByEmailAndPassword(String email, String password) {
		TypedQuery<Users> qlString = em.createNamedQuery("Users.findUserByEmailAndPassword", Users.class);
		 qlString.setParameter("email", email);
		 qlString.setParameter("password", password);
		List<Users> user = qlString.getResultList();
		if (user != null && user.size() == 1) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Users createUser(Users users) {
		em.persist(users);
		return users;
	}

	@Override
	public List<Users> findAllUsers() {

		TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u ORDER BY u.id ASC", Users.class);

		List<Users> Users = query.getResultList();
		return Users;

	}

	

	@Override
	public Users updateUser(Users user) {

		return em.merge(user);
	}

	@Override
	public void deleteUser(Users user) {
		em.remove(user);

	}

}
