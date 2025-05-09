package com.tep.backend.model.dto;

import com.tep.backend.model.entity.Token;
import com.tep.backend.model.entity.TokenType;

import java.time.LocalDateTime;

public class TokenDTO {

    private Long id;
    private Long companyId;
    private TokenType type;
    private ProductDTO product;
    private String name;
    private String symbol;
    private String description;
    private String imageUrl;
    private String contractAddress;
    private LocalDateTime createdAt;
    private Boolean active;

    public TokenDTO() {
    }

    public TokenDTO(Token entity) {
        id = entity.getId();
        companyId = entity.getCompany().getId();
        type = entity.getType();
        if (entity.getProduct() != null) {
            product = new ProductDTO(entity.getProduct());
        }
        name = entity.getName();
        symbol = entity.getSymbol();
        description = entity.getDescription();
        imageUrl = entity.getImageUrl();
        contractAddress = entity.getContractAddress();
        createdAt = entity.getCreatedAt();
        active = entity.getActive();
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

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
