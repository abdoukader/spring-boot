package com.senebaTransfert.senebatrans.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "compte")
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@NotBlank
    @Column(length = 30)
    private int numerocompte;
    //@NotBlank
    @Column(length = 50)
    private int solde;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datecreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn

    private Partenaire partenaire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumerocompte() {
        return numerocompte;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) { this.solde = solde; }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public void setNumerocompte(int numerocompte) {
        this.numerocompte = numerocompte;
    }

    public void setPartenaire() { }
}