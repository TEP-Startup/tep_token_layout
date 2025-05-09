package com.tep.backend.model.dto;

import com.tep.backend.model.entity.Company;

public class CompanyPublicDTO {

    private Long id;
    private String name;
    private String description;
    private String sector;
    private String logoUrl;
    private String website;

    public CompanyPublicDTO() {
    }

    public CompanyPublicDTO(Company entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        sector = entity.getSector();
        logoUrl = entity.getLogoUrl();
        website = entity.getWebsite();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
