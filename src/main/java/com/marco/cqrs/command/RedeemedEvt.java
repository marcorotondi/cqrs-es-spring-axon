package com.marco.cqrs.command;

import java.util.Objects;

public class RedeemedEvt {

    private final String id;

    private final Long amount;

    public RedeemedEvt(String id, Long amount) {
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
        RedeemedEvt that = (RedeemedEvt) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAmount(), that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }

    @Override
    public String toString() {
        return "RedeemedEvt{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
