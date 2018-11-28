package com.marco.cqrs.query;

import java.io.Serializable;
import java.util.Objects;

public class CardSummariesUpdatedEvt implements Serializable {

    private final String id;

    public CardSummariesUpdatedEvt(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardSummariesUpdatedEvt that = (CardSummariesUpdatedEvt) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "CardSummariesUpdatedEvt{" +
                "id='" + id + '\'' +
                '}';
    }
}
