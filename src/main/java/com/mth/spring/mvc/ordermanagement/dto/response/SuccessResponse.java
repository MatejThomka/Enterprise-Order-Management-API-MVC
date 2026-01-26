package com.mth.spring.mvc.ordermanagement.dto.response;

import java.time.Instant;

/**
 * Represents a successful response with data, status code, and timestamp.
 */
public record SuccessResponse<T> (int status, T responseData, Instant timestamp) implements Response<T> {
    
    /**
     * Constructs a SuccessResponse with the current timestamp.
     *
     * @param status the HTTP status code
     * @param data   the response data
     */
    public SuccessResponse {
        if (timestamp == null) {
            timestamp = Instant.now();
        }
    }
}
