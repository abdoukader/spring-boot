package com.senebaTransfert.senebatrans.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "partenaires")
@Table(name = "partenaire")
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(length = 30)
    private String adresse;

    @NotBlank
    @Column(length = 30)
    private String email;

    @NotBlank
    @Column(length = 30)
    private String nomentreprise;

    @NotBlank
    @Column(length = 30)
    private String telephone;

    @NotBlank
    @Column(length = 30)
    private String nomComplet;
    @NotBlank
    @Column(length = 50)
    private String ninea;

    @NotBlank
    @Column(length = 50)
    private String phone;
    @NotBlank
    @Column(length = 50)
    private String raisonsocial;

    @OneToMany(mappedBy ="partenaire",cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy ="partenaire",cascade = CascadeType.ALL)
    private List<Compte> comptes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRaisonsocial() {
        return raisonsocial;
    }

    public void setRaisonsocial(String raisonsocial) {
        this.raisonsocial = raisonsocial;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }


    public Compte get(int i) {
        return null;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}