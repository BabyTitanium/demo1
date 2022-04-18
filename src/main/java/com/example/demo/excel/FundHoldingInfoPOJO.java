package com.example.demo.excel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FundHoldingInfoPOJO {
    private Long clientId;
    private Long productId;
    private String currencyCode;
    private LocalDate startDate;
    private BigDecimal holdingShares;
    private BigDecimal totalBuyAmount;
    private BigDecimal totalBuyShares;
    private BigDecimal totalBuyFare;
    private BigDecimal totalSellAmount;
    private BigDecimal totalSellFare;
    private BigDecimal dilutedCost;
    private BigDecimal averageCost;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getHoldingShares() {
        return holdingShares;
    }

    public void setHoldingShares(BigDecimal holdingShares) {
        this.holdingShares = holdingShares;
    }

    public BigDecimal getTotalBuyAmount() {
        return totalBuyAmount;
    }

    public void setTotalBuyAmount(BigDecimal totalBuyAmount) {
        this.totalBuyAmount = totalBuyAmount;
    }

    public BigDecimal getTotalBuyShares() {
        return totalBuyShares;
    }

    public void setTotalBuyShares(BigDecimal totalBuyShares) {
        this.totalBuyShares = totalBuyShares;
    }

    public BigDecimal getTotalBuyFare() {
        return totalBuyFare;
    }

    public void setTotalBuyFare(BigDecimal totalBuyFare) {
        this.totalBuyFare = totalBuyFare;
    }

    public BigDecimal getTotalSellAmount() {
        return totalSellAmount;
    }

    public void setTotalSellAmount(BigDecimal totalSellAmount) {
        this.totalSellAmount = totalSellAmount;
    }

    public BigDecimal getTotalSellFare() {
        return totalSellFare;
    }

    public void setTotalSellFare(BigDecimal totalSellFare) {
        this.totalSellFare = totalSellFare;
    }

    public BigDecimal getDilutedCost() {
        return dilutedCost;
    }

    public void setDilutedCost(BigDecimal dilutedCost) {
        this.dilutedCost = dilutedCost;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }
}
