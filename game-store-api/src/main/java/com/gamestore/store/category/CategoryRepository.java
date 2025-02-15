package com.gamestore.store.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

//    find all the categories by name starting with
//    Select * from category where name like 'a%' order by name asc

    List<Category> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

//    JPQL Syntax
    @Query("""
            SELECT c from Category c
            WHERE c.name LIKE lower (:name)
            ORDER BY c.name ASC
    """)
    List<Category> findAllByName(@Param("name") String categoryName);

    @NativeQuery(value = "select * from category where name like lower(:catName) order by name asc ")
    List<Category> findAllByNameUsingNativeQuery(@Param("catName") String categoryName);

    @Query(name = "Category.findByName")
    List<Category> findAllByNamedQuery(
           @Param("catName") String categoryName);

}
