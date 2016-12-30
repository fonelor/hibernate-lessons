package ru.rolsoft.hibernate.lesson1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by rolenof on 29.12.16.
 */
@Slf4j
@Data
@Entity
@Table(name = "Role", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "NAME")
})
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long roleId;

    @Column(name = "NAME", unique = true, nullable = false, length = 100)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Set<EmployeeEntity> employees;
}
