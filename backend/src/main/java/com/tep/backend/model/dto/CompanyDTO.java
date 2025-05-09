package com.tep.backend.model.dto;

import com.tep.backend.model.entity.Company;
import com.tep.backend.model.entity.CompanyStatus;

import java.time.LocalDate;

public class CompanyDTO {

    private Long id;
    private String name;
    private String description;
    private String sector;
    private String logoUrl;
    private String website;
    private String email;
    private String phone;
    private String cnpj;
    private CompanyStatus status;
    private LocalDate registeredAt;
    private Long tokenId;

    public CompanyDTO() {
    }

    public CompanyDTO(Company entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        sector = entity.getSector();
        logoUrl = entity.getLogoUrl();
        website = entity.getWebsite();
        email = entity.getEmail();
        phone = entity.getPhone();
        cnpj = entity.getCnpj();
        status = entity.getStatus();
        registeredAt = entity.getRegisteredAt();
        tokenId = (entity.getToken() != null) ? entity.getToken().getId() : null;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public CompanyStatus getStatus() {
        return status;
    }

    public void setStatus(CompanyStatus status) {
        this.status = status;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }
}
