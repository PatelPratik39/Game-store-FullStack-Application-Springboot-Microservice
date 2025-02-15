package com.gamestore.store.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

//    find all the categories by name starting with
//    Select * from category where name like 'a%' order by name asc
    List<Category> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

}
