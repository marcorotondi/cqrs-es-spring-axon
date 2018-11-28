package com.marco.cqrs.command;

import java.util.Objects;

public class IssueCmd {

    private final String id;

    private final Long amount;

    public IssueCmd(String id, Long amount) {
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
        IssueCmd issueCmd = (IssueCmd) o;
        return Objects.equals(getId(), issueCmd.getId()) &&
                Objects.equals(getAmount(), issueCmd.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }

    @Override
    public String toString() {
        return "IssueCmd{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
