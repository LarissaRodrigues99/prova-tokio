package br.com.tokiomarine.seguradora.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Table(name="addresses")
@Entity
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @ManyToOne
        @NotNull
        @JoinColumn(name = "id_client")
        private Clients clients;

        @NotNull
        @Column(name = "address")
        private String address;

        @NotNull
        @Column(name = "number")
        private String number;

        @Column(name = "complement")
        private String complement;

        @Column(name = "postalCode")
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
