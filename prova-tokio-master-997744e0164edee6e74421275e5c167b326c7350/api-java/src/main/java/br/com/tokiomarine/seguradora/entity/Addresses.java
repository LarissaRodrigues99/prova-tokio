package br.com.tokiomarine.seguradora.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table(name="addresses")
@Entity
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
        private Clients client;

        private String address;
        private String number;
        private String complement;
        private String postal_code;
        private String city;
        private String state;
        private String country;
}
