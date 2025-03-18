package br.com.tokiomarine.seguradora.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

import javax.persistence.Id;

@Entity
@Table(name ="addresses")
@EqualsAndHashCode(of= "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @JoinColumn(name = "id_client", referencedColumnName = "id")
        @ManyToOne
        private Clients client;

        @Column(name = "address")
        private String address;

        @Column(name = "number")
        private String number;

        @Column(name = "complement")
        private String complement;

        @Column(name = "postal_code")
        private String postalCode;

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
