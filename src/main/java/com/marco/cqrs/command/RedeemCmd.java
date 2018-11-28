package com.marco.cqrs.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class RedeemCmd {

    @TargetAggregateIdentifier
    private final String id;

    private final Long amount;

    public RedeemCmd(String id, Long amount) {
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
        RedeemCmd redeemCmd = (RedeemCmd) o;
        return Objects.equals(getId(), redeemCmd.getId()) &&
                Objects.equals(getAmount(), redeemCmd.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }

    @Override
    public String toString() {
        return "RedeemCmd{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
