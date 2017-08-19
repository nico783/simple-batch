package com.example.simplebatch.reader.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "gdlivre2016")
public class ReadEntity {

	@Id
	private Long numero;

	private Long payeur;

	private Long client;

	private String date;

	private String descriptif;

	private Double quantite;

	private Double prixunitaire;

	private Double tva;

	private String famille;

	private Date dt_journal;

	private String texte_complementaire;

	private Date dt_enreg;

	private Long id_divers;

	private String id_fdc;

    public ReadEntity() {
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getPayeur() {
        return payeur;
    }

    public void setPayeur(Long payeur) {
        this.payeur = payeur;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public Date getDt_journal() {
        return dt_journal;
    }

    public void setDt_journal(Date dt_journal) {
        this.dt_journal = dt_journal;
    }

    public String getTexte_complementaire() {
        return texte_complementaire;
    }

    public void setTexte_complementaire(String texte_complementaire) {
        this.texte_complementaire = texte_complementaire;
    }

    public Date getDt_enreg() {
        return dt_enreg;
    }

    public void setDt_enreg(Date dt_enreg) {
        this.dt_enreg = dt_enreg;
    }

    public Long getId_divers() {
        return id_divers;
    }

    public void setId_divers(Long id_divers) {
        this.id_divers = id_divers;
    }

    public String getId_fdc() {
        return id_fdc;
    }

    public void setId_fdc(String id_fdc) {
        this.id_fdc = id_fdc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadEntity that = (ReadEntity) o;

        return numero != null ? numero.equals(that.numero) : that.numero == null;
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ReadEntity{" +
                "numero=" + numero +
                ", payeur=" + payeur +
                ", client=" + client +
                ", date='" + date + '\'' +
                ", descriptif='" + descriptif + '\'' +
                ", quantite=" + quantite +
                ", prixunitaire=" + prixunitaire +
                ", tva=" + tva +
                ", famille='" + famille + '\'' +
                ", dt_journal=" + dt_journal +
                ", texte_complementaire='" + texte_complementaire + '\'' +
                ", dt_enreg=" + dt_enreg +
                ", id_divers=" + id_divers +
                ", id_fdc='" + id_fdc + '\'' +
                '}';
    }
}
