package com.tep.backend.model.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class TransferDTO {

    private String fromAddress;
    private String toAddress;
    private BigInteger amount;
    private String transactionHash;
    private LocalDateTime timestamp;

    public TransferDTO() {
    }

    public TransferDTO(String fromAddress, String toAddress, BigInteger amount, String transactionHash, LocalDateTime timestamp) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.amount = amount;
        this.transactionHash = transactionHash;
        this.timestamp = timestamp;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
