package com.postgres.hibernate.models;

import javax.persistence.*;

@Entity
@Table
public class Country {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "country_Id", unique = true, nullable = false)
    private Integer id;

    @Column(name="country_name", unique = true, nullable = false)
    private String countryName;

    @Column(name="continent", nullable = false)
    private String continent;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="dial_in_detail_id")
    private DialInDetails dialInDetails;


    public Country() {
    }

    public Country(String countryName, String continent) {
        this.countryName = countryName;
        this.continent = continent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public DialInDetails getDialInDetails() {
        return dialInDetails;
    }

    public void setDialInDetails(DialInDetails dialInDetails) {
        this.dialInDetails = dialInDetails;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("id=").append(id);
        sb.append(", countryName='").append(countryName).append('\'');
        sb.append(", continent='").append(continent).append('\'');
        sb.append(", dialInDetails=").append(dialInDetails);
        sb.append('}');
        return sb.toString();
    }
}
