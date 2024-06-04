package org.example.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Column(name = "email_addresses")
    @JsonManagedReference
    private List<EmailAddress> emailAddresses;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Column(name = "mobile_numbers")
    @JsonManagedReference
    private List<MobileNumber> mobileNumbers;

    public User(List<EmailAddress> pEmailAddresses, String pFullName, List<MobileNumber> pMobileNumbers) {
        emailAddresses = pEmailAddresses;
        fullName = pFullName;
        mobileNumbers = pMobileNumbers;
    }
}
