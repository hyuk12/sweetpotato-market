package com.market.sweetpotato.api.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "authority_mst")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Authority {

    @Id
    @Column(name = "authority_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

}
