package com.market.sweetpotato.api.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role_mst")
@Getter
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roleName;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<Authority> authorities;

}
