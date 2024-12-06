
package com.sportcenter.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_roles", // Nome della tabella di join
        joinColumns = @JoinColumn(name = "user_id"), // Colonna di join per User
        inverseJoinColumns = @JoinColumn(name = "role_id") // Colonna di join per Role
    )
    private Set<Ruolo> ruolo = new HashSet<>();

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ruolo> getRuolo() {
        return ruolo;
    }

    public void setRuolo(Set<Ruolo> ruolo) {
        this.ruolo = ruolo;
    }

}
