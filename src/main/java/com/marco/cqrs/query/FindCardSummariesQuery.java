package com.marco.cqrs.query;

import java.io.Serializable;
import java.util.Objects;

public class FindCardSummariesQuery implements Serializable {

    private final Integer offset;

    private final Integer limit;

    public FindCardSummariesQuery(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindCardSummariesQuery that = (FindCardSummariesQuery) o;
        return Objects.equals(getOffset(), that.getOffset()) &&
                Objects.equals(getLimit(), that.getLimit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffset(), getLimit());
    }

    @Override
    public String toString() {
        return "FindCardSummariesQuery{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
