package ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.DAO.CategoryDAO;
import ecommerce.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/category")

	public String showCategory(Model m) {

		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);
		m.addAttribute("pageinfo", "AboutUs");
		return "Category";

	}

	@RequestMapping(value = "/AddCateory", method = RequestMethod.POST)

	public String addCategory(Model m, @RequestParam("catgName") String categoryName,
			@RequestParam("catgDesc") String CategoryDesc) {

		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(CategoryDesc);
		categoryDAO.addCategory(category);

		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);

		m.addAttribute("pageinfo", "Manage Category");
		return "Category";
	}

	@RequestMapping(value = "/UpdateCateory", method = RequestMethod.POST)

	public String updateCategory(Model m, @RequestParam("catgId") int categoryId,
			@RequestParam("catgName") String categoryName, @RequestParam("catgDesc") String CategoryDesc) {

		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(CategoryDesc);
		categoryDAO.addCategory(category);

		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);

		m.addAttribute("pageinfo", "Manage Category");
		return "Category";
	}

	@RequestMapping(value = "/deleteCateory/{categoryId}")

	public String deleteCategory(Model m, @PathVariable("categoryId") int categoryId) {
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);

		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);

		m.addAttribute("pageinfo", "Manage Category");
		return "Category";

	}

	@RequestMapping(value = "/editCateory/{categoryId}")

	public String editCategory(Model m, @PathVariable("categoryId") int categoryId) {

		Category category = categoryDAO.getCategory(categoryId);

		m.addAttribute("category", category);

		return "UpdateCategory";
	}

}
