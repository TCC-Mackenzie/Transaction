package tcc.bank.transaction.dto;

import tcc.bank.transaction.service.model.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDTO {
    private Date date;

    private TransactionType type;

    private BigDecimal value;

    private Integer accountId;

    public TransactionDTO() { }

    public TransactionDTO(Date date, TransactionType type, BigDecimal value, Integer accountId) {
        this.date = date;
        this.type = type;
        this.value = value;
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
