package com.marco.cqrs.command;

import java.util.Objects;

public class IssuedEvt {

    private final String id;

    private final Long amount;

    public IssuedEvt(String id, Long amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedEvt issuedEvt = (IssuedEvt) o;
        return Objects.equals(getId(), issuedEvt.getId()) &&
                Objects.equals(getAmount(), issuedEvt.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }

    @Override
    public String toString() {
        return "IssuedEvt{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
