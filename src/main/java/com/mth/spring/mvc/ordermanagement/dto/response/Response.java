package com.mth.spring.mvc.ordermanagement.dto.response;

import java.time.Instant;

/** Represents a generic response interface for API responses. */
public sealed interface Response<T> permits SuccessResponse, EmptySuccessResponse, ErrorResponse {
  int status();

  Instant timestamp();

  /** Factory method to create a SuccessResponse with data. */
  static <T> Response<T> of(int status, T responseData) {
    return new SuccessResponse<>(status, responseData, Instant.now());
  }

  /** Factory method to create an EmptySuccessResponse. */
  static Response<Void> empty(int status) {
    return new EmptySuccessResponse(status, Instant.now());
  }

  /** Factory method to create an ErrorResponse. */
  static Response<Void> error(int status, ErrorDetail errorDetail) {
    return new ErrorResponse(status, errorDetail, Instant.now());
  }
}
