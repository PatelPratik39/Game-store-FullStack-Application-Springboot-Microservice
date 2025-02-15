package com.gamestore.store.game;

import com.gamestore.store.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByCategory(Category category);   // find all games by category

    List<Game> findAllByCategoryId(String categoryId);

//    find all games where the name equals 'Action'
    List<Game> findAllByCategoryName(String categoryName);

//    JPQL syntax
    /* @Query("""
       Select g FROM Game g
        INNER JOIN g.category c ON g.category.id = c.id
        WHERE c.name LIKE :catName
    """) */

    @Query("""
       Select g FROM Game g
        INNER JOIN g.category c
        WHERE c.name LIKE :catName
    """)
    List<Game> findAllByCat(@Param("name") String catName);


    @Query("""
        UPDATE Game SET title = upper(title)
    """)
    @Modifying
    void transformGamesTitleToUpperCase();

}
