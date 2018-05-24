package net.kzn.shoppingbackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context =new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
		
		
	}
	
	/*@Test
	public void testAddCategory() {
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is Some Description of Laptop");
		category.setImageURL("CAT_105.png");
		
		assertEquals("Sucessfully Added a Category inside the table", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(1);
		assertEquals("Sucessfully  fetched a single cagtegory from the table","Television", category.getName());
		
	}*/

	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Sucessfully  Update a single cagtegory from the table",true , categoryDAO.update(category));
		
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(1);
		assertEquals("Sucessfully  deleted a single cagtegory from the table",true , categoryDAO.delete(category));
		
	}*/
	
	/*@Test
	public void testListCategory() {
		
		
		assertEquals("Sucessfully  fetched the list of  cagtegories  from the table",1, categoryDAO.list().size());
		
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		//add operation
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is Some Description of Laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Sucessfully Added a Category inside the table", true, categoryDAO.add(category));
		
		category=new Category();
		category.setName("Television");
		category.setDescription("This is Some Description of Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Sucessfully Added a Category inside the table", true, categoryDAO.add(category));
		
		//fetching and vupdating the category
		
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Sucessfully  Update a single cagtegory from the table",true , categoryDAO.update(category));
		
		//delete the category
		
		category = categoryDAO.get(1);
		assertEquals("Sucessfully  deleted a single cagtegory from the table",true , categoryDAO.delete(category));
		
		//fetching the list
		
		
		assertEquals("Sucessfully  fetched the list of  cagtegories  from the table",1, categoryDAO.list().size());
		
	}
}
