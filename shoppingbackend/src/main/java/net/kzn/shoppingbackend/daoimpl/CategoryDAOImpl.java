package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// private static List<Category> categories = new ArrayList<>();
	//
	// static {
	// Category category = new Category();
	//
	// // adding first category
	// category.setId(1);
	// category.setName("Television");
	// category.setDescription("This is some description for Television");
	// category.setImageURL("CAT_1.png");
	// categories.add(category);
	//
	// // adding Second category
	// category = new Category();
	// category.setId(2);
	// category.setName("mobile");
	// category.setDescription("This is some description for mobile");
	// category.setImageURL("CAT_2.png");
	// categories.add(category);
	//
	// // adding Second category
	// category = new Category();
	// category.setId(3);
	// category.setName("Laptop");
	// category.setDescription("This is some description for Laptop");
	// category.setImageURL("CAT_3.png");
	// categories.add(category);
	// }

	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active=:active";
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Category get(int id) {

		/*
		 * Getting Single Category bases on id
		 * 
		 */

		// enhance for loop

		// for (Category category : categories) {
		// if (category.getId() == id)
		// return category;
		// }
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {

		try {
			// add the Category to database table

			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * 
	 * Updating a Single Category
	 */

	@Override
	public boolean update(Category category) {
		try {
			
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}
	
	/*
	 * 
	 * deleting a Single Category
	 */
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}
}
