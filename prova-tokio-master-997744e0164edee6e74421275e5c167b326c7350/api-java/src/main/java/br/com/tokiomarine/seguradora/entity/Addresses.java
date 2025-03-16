package br.com.tokiomarine.seguradora.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;

@Table(name="addresses")
@Entity
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {
        @Id
        @Column(name = "id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "id_client")
        private Clients client;

        @Column(name = "address")
        private String address;

        @Column(name = "number")
        private String number;

        @Column(name = "complement")
        private String complement;

        @Column(name = "postal_code")
        private String postal_code;

        @Column(name = "city")
        private String city;

        @Column(name = "state")
        private String state;

        @Column(name = "country")
        private String country;

        @CreationTimestamp
        private Instant creationTimestamp;

        @UpdateTimestamp
        private Instant updateTimestamp;
}
