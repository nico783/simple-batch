package com.example.simplebatch.writer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class WriteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String customerKey;
    private String login;
    private String password;
    private String rateBand;
    private String orangeCode;
    private String saariCode;
    private String customerType;
    private Date creationDate;
    private Date changeDate;
    private Long partner_idFK;
    private Long handle_idFK;
    private Long customer_idFK;
    private String createdBy;
    private String activationKey;
    private Integer isAccountValidated;
    private Date lastLoginDate;
    private Date accountValidationDate;
    private Integer isMarguerite;
    private Date dateRegistrationMarguerite;
    private String versionMarguerite;
    private Integer isRejection;
    private String segment_tva;
    private String orderRef;
    private String sendDocumentBy;
    private Long siret;
    private String code_ape;
    private String facture_0_euro;
    private Date birth_date;
    private String payment_period;

    public WriteEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRateBand() {
        return rateBand;
    }

    public void setRateBand(String rateBand) {
        this.rateBand = rateBand;
    }

    public String getOrangeCode() {
        return orangeCode;
    }

    public void setOrangeCode(String orangeCode) {
        this.orangeCode = orangeCode;
    }

    public String getSaariCode() {
        return saariCode;
    }

    public void setSaariCode(String saariCode) {
        this.saariCode = saariCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Long getPartner_idFK() {
        return partner_idFK;
    }

    public void setPartner_idFK(Long partner_idFK) {
        this.partner_idFK = partner_idFK;
    }

    public Long getHandle_idFK() {
        return handle_idFK;
    }

    public void setHandle_idFK(Long handle_idFK) {
        this.handle_idFK = handle_idFK;
    }

    public Long getCustomer_idFK() {
        return customer_idFK;
    }

    public void setCustomer_idFK(Long customer_idFK) {
        this.customer_idFK = customer_idFK;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public Integer getIsAccountValidated() {
        return isAccountValidated;
    }

    public void setIsAccountValidated(Integer isAccountValidated) {
        this.isAccountValidated = isAccountValidated;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getAccountValidationDate() {
        return accountValidationDate;
    }

    public void setAccountValidationDate(Date accountValidationDate) {
        this.accountValidationDate = accountValidationDate;
    }

    public Integer getIsMarguerite() {
        return isMarguerite;
    }

    public void setIsMarguerite(Integer isMarguerite) {
        this.isMarguerite = isMarguerite;
    }

    public Date getDateRegistrationMarguerite() {
        return dateRegistrationMarguerite;
    }

    public void setDateRegistrationMarguerite(Date dateRegistrationMarguerite) {
        this.dateRegistrationMarguerite = dateRegistrationMarguerite;
    }

    public String getVersionMarguerite() {
        return versionMarguerite;
    }

    public void setVersionMarguerite(String versionMarguerite) {
        this.versionMarguerite = versionMarguerite;
    }

    public Integer getIsRejection() {
        return isRejection;
    }

    public void setIsRejection(Integer isRejection) {
        this.isRejection = isRejection;
    }

    public String getSegment_tva() {
        return segment_tva;
    }

    public void setSegment_tva(String segment_tva) {
        this.segment_tva = segment_tva;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getSendDocumentBy() {
        return sendDocumentBy;
    }

    public void setSendDocumentBy(String sendDocumentBy) {
        this.sendDocumentBy = sendDocumentBy;
    }

    public Long getSiret() {
        return siret;
    }

    public void setSiret(Long siret) {
        this.siret = siret;
    }

    public String getCode_ape() {
        return code_ape;
    }

    public void setCode_ape(String code_ape) {
        this.code_ape = code_ape;
    }

    public String getFacture_0_euro() {
        return facture_0_euro;
    }

    public void setFacture_0_euro(String facture_0_euro) {
        this.facture_0_euro = facture_0_euro;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPayment_period() {
        return payment_period;
    }

    public void setPayment_period(String payment_period) {
        this.payment_period = payment_period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WriteEntity that = (WriteEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WriteEntity{" +
                "id=" + id +
                ", customerKey='" + customerKey + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rateBand='" + rateBand + '\'' +
                ", orangeCode='" + orangeCode + '\'' +
                ", saariCode='" + saariCode + '\'' +
                ", customerType='" + customerType + '\'' +
                ", creationDate=" + creationDate +
                ", changeDate=" + changeDate +
                ", partner_idFK=" + partner_idFK +
                ", handle_idFK=" + handle_idFK +
                ", customer_idFK=" + customer_idFK +
                ", createdBy='" + createdBy + '\'' +
                ", activationKey='" + activationKey + '\'' +
                ", isAccountValidated=" + isAccountValidated +
                ", lastLoginDate=" + lastLoginDate +
                ", accountValidationDate=" + accountValidationDate +
                ", isMarguerite=" + isMarguerite +
                ", dateRegistrationMarguerite=" + dateRegistrationMarguerite +
                ", versionMarguerite='" + versionMarguerite + '\'' +
                ", isRejection=" + isRejection +
                ", segment_tva='" + segment_tva + '\'' +
                ", orderRef='" + orderRef + '\'' +
                ", sendDocumentBy='" + sendDocumentBy + '\'' +
                ", siret=" + siret +
                ", code_ape='" + code_ape + '\'' +
                ", facture_0_euro='" + facture_0_euro + '\'' +
                ", birth_date=" + birth_date +
                ", payment_period='" + payment_period + '\'' +
                '}';
    }
}
