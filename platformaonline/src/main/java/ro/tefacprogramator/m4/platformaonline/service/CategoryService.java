package ro.tefacprogramator.m4.platformaonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.tefacprogramator.m4.platformaonline.entity.Category;
import ro.tefacprogramator.m4.platformaonline.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    public CategoryRepository repo;

    public boolean updateCategory(Category c1) {
        Category saved = repo.save(c1);

        if (saved != null) {
            return true;
        }
        return false;
    }
}
