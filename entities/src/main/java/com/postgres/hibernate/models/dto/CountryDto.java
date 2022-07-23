package com.postgres.hibernate.models.dto;

public class CountryDto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String countryName;

    private String continent;


//    public CountryDto() {
//    }

    public CountryDto(Integer id, String countryName, String continent) {
        this.id = id;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("id=").append(id);
        sb.append(", countryName='").append(countryName).append('\'');
        sb.append(", continent='").append(continent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
