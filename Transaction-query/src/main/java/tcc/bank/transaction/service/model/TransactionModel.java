package tcc.bank.transaction.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "transaction")
public class TransactionModel {

    @Id
    private Integer id;

    private Date date;

    private Integer type;

    private BigDecimal value;

    private Integer accountId;

    public TransactionModel(Integer id, Date date, Integer type, BigDecimal value, Integer accountId) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.value = value;
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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
