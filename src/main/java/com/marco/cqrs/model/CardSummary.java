package com.marco.cqrs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;

@Entity
public class CardSummary {

    private String id;

    private Long initialValue;

    private Instant issuedAt;

    private Long remainingValue;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Long initialValue) {
        this.initialValue = initialValue;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Instant issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Long getRemainingValue() {
        return remainingValue;
    }

    public void setRemainingValue(Long remainingValue) {
        this.remainingValue = remainingValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardSummary that = (CardSummary) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getInitialValue(), that.getInitialValue()) &&
                Objects.equals(getIssuedAt(), that.getIssuedAt()) &&
                Objects.equals(getRemainingValue(), that.getRemainingValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInitialValue(), getIssuedAt(), getRemainingValue());
    }
}
