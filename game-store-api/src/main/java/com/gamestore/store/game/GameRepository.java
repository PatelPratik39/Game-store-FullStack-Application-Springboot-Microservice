package com.gamestore.store.game;

import com.gamestore.store.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByCategory(Category category);   // find all games by category

    List<Game> findAllByCategoryId(String categoryId);

//    find all games where the name equals 'Action'

    List<Game> findAllByCategoryName(String categoryName);
}
