package com.scorpions.search.req;

import lombok.Data;

@Data
public class SearchRequest {

    private Filter filter;
    private String value;
}
