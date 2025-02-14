package com.gamestore.store.wishlist;

import com.gamestore.store.common.BaseEntity;
import com.gamestore.store.game.Game;
import com.gamestore.store.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WishList extends BaseEntity {
    private String name;

    @OneToOne
    private User user;

    @ManyToMany

    private List<Game> games;
}
