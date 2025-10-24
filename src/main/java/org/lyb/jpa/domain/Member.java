package org.lyb.jpa.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private String email;
    //private String memo;
    @Column(name="address")
    private String addr;
}
