package com.tep.backend.model.dto;

import com.tep.backend.model.entity.Product;
import java.time.LocalDateTime;

public class ProductDTO {

    private Long id;
    private Long companyId;
    private String name;
    private String description;
    private String imageUrl;
    private String redemptionRules;
    private LocalDateTime validityPeriod;
    private Boolean active;
    private LocalDateTime createdAt;

    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        companyId = entity.getCompany().getId();
        name = entity.getName();
        description = entity.getDescription();
        imageUrl = entity.getImageUrl();
        redemptionRules = entity.getRedemptionRules();
        validityPeriod = entity.getValidityPeriod();
        active = entity.getActive();
        createdAt = entity.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRedemptionRules() {
        return redemptionRules;
    }

    public void setRedemptionRules(String redemptionRules) {
        this.redemptionRules = redemptionRules;
    }

    public LocalDateTime getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(LocalDateTime validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
