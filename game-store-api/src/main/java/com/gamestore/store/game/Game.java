package com.gamestore.store.game;

import com.gamestore.store.category.Category;
import com.gamestore.store.comment.Comment;
import com.gamestore.store.common.BaseEntity;
import com.gamestore.store.wishlist.WishList;
import jakarta.persistence.*;
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
public class Game extends BaseEntity {

    private String title;
    @Enumerated(EnumType.STRING)
    private SupportedPlatforms supportedPlatforms;
    private String coverPicture;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "game")
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "game_wishlist",joinColumns = {
            @JoinColumn(
                    name = "game_id"
            )
    }, inverseJoinColumns = {
            @JoinColumn(name = "wishlist_id")
    })
    private List<WishList> wishList;

    public void addWishList(WishList wishList) {
        this.wishList.add(wishList);
        wishList.getGames().add(this);
    }

    public void removeWishList(WishList wishList) {
        this.wishList.remove(wishList);
        wishList.getGames().remove(this);
    }

}
