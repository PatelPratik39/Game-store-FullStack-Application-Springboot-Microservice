package com.gamestore.store.category;

import com.gamestore.store.common.BaseEntity;
import com.gamestore.store.game.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = " Category.findByName",
        query = "SELECT c from Category c " +
                "WHERE c.name LIKE lower (:name)" +
                "ORDER BY c.name ASC")

public class Category extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Game> games;

//    Auditing fields like creation Date, created By
}
