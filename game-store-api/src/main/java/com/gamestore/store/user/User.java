package com.gamestore.store.user;

import com.gamestore.store.common.BaseEntity;
import com.gamestore.store.gamerequest.GameRequest;
import com.gamestore.store.notification.Notification;
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
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String profilePictureUrl;

    @OneToOne(mappedBy = "user")
    private WishList wishList;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user")
    private List<GameRequest> gameRequests;
}
