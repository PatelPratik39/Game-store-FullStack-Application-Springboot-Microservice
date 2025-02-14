package com.gamestore.store.gamerequest;

import com.gamestore.store.common.BaseEntity;
import com.gamestore.store.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GameRequest extends BaseEntity {

    private String title;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
