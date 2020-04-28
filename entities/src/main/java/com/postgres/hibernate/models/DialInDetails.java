package com.postgres.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "dial_in_details")
public class DialInDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "dial_in_detail_Id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "country_code", unique = true, nullable = false)
    private String countryCode;

    @Column(name = "country_dial_in_code", unique = true, nullable = false)
    private String countryDialInCode;

    @OneToOne(mappedBy="dialInDetails", cascade=CascadeType.ALL)
    private Country country;

    public DialInDetails() {
    }

    public DialInDetails(String countryCode, String countryDialInCode) {
        this.countryCode = countryCode;
        this.countryDialInCode = countryDialInCode;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryDialInCode() {
        return countryDialInCode;
    }

    public void setCountryDialInCode(String countryDialInCode) {
        this.countryDialInCode = countryDialInCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DialInDetails{");
        sb.append("id=").append(id);
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append(", countryDialInCode='").append(countryDialInCode);
        sb.append('}');
        return sb.toString();
    }
}
