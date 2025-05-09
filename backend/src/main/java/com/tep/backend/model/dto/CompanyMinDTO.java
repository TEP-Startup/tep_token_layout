package com.tep.backend.model.dto;

import com.tep.backend.model.entity.Company;

public class CompanyMinDTO {

    private Long id;
    private String name;
    private String sector;
    private String logoUrl;

    public CompanyMinDTO() {
    }

    public CompanyMinDTO(Company entity) {
        id = entity.getId();
        name = entity.getName();
        sector = entity.getSector();
        logoUrl = entity.getLogoUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
