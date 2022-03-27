package ro.tefacprogramator.m4.platformaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.tefacprogramator.m4.platformaonline.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    
}
