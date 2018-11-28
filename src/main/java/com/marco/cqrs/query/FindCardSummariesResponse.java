package com.marco.cqrs.query;

import com.marco.cqrs.model.CardSummary;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FindCardSummariesResponse implements Serializable {

    private final List<CardSummary> data;

    public FindCardSummariesResponse(List<CardSummary> data) {
        this.data = data;
    }

    public List<CardSummary> getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindCardSummariesResponse that = (FindCardSummariesResponse) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "FindCardSummariesResponse{" +
                "data=" + data +
                '}';
    }
}
