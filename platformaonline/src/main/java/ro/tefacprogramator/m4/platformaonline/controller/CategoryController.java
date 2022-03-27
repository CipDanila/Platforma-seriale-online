package ro.tefacprogramator.m4.platformaonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ro.tefacprogramator.m4.platformaonline.entity.Category;
import ro.tefacprogramator.m4.platformaonline.service.CategoryService;


@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PutMapping("/category/update/{id}")
    public String updateCategory(
        @PathVariable(value = "id") Integer id, 
        @RequestBody Category c1) {
        
            c1.setIdCategory(id);

        if (service.updateCategory(c1)) {
            return "success";
        }

        return "failed";
    }
    
}
