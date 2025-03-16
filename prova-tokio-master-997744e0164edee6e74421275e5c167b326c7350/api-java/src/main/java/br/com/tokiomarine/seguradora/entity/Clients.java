package br.com.tokiomarine.seguradora.domain;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table(name="clients")
@Entity
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String email;

//    @OneToMany(mappedBy = "client")
//    private List<Addresses> addresses;

}
