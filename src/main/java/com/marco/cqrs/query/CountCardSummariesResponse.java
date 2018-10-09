package com.marco.cqrs.query;

import java.io.Serializable;
import java.util.Objects;

public class CountCardSummariesResponse implements Serializable {

    private final Long count;


    public CountCardSummariesResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountCardSummariesResponse that = (CountCardSummariesResponse) o;
        return Objects.equals(getCount(), that.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount());
    }

    @Override
    public String toString() {
        return "CountCardSummariesResponse{" +
                "count=" + count +
                '}';
    }
}
