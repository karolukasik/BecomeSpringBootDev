package io.datajek.databaserelationships.manytomany.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.manytomany.Category;
import io.datajek.databaserelationships.manytomany.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public List<Category> allCategories() {
		return repo.findAll();	    
	}

    public Category getCategory(int id) {
        Optional<Category> optCategory = repo.findById(id);
        if (optCategory.isEmpty()) {
            throw new EntityNotFoundException("There is no category with id " + id);
        }
        return optCategory.get();
    }

    public Category addCategory(Category category) {
    	category.setId(0);
		return repo.save(category);
	}
    
 	public void deleteCategory(int id) {
        Optional<Category> optCategory = repo.findById(id);
        if (optCategory.isEmpty()) {
            throw new EntityNotFoundException("There is no category with id " + id);
        }
        repo.deleteById(id);
	}


}
