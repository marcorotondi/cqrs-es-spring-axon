package com.marco.cqrs.query;

import java.util.Objects;

public class FetchCardSummariesQuery {

    private final Long offset;

    private final Long limit;

    public FetchCardSummariesQuery(Long offset, Long limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public Long getLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchCardSummariesQuery that = (FetchCardSummariesQuery) o;
        return Objects.equals(getOffset(), that.getOffset()) &&
                Objects.equals(getLimit(), that.getLimit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffset(), getLimit());
    }

    @Override
    public String toString() {
        return "FetchCardSummariesQuery{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
