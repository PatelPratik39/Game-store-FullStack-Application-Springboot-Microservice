package com.gamestore.store.game;

import com.gamestore.store.category.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public void something(String categoryId) {
        var games = gameRepository.findAllByCategoryId(categoryId);
    }
}

