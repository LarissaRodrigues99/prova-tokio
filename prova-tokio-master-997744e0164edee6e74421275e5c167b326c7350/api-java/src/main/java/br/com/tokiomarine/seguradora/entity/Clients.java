package br.com.tokiomarine.seguradora.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Table(name="clients")
@Entity
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Addresses> addresses;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

}
