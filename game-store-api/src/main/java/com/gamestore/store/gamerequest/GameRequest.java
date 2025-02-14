package com.gamestore.store.gamerequest;

import com.gamestore.store.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
}
