package com.mth.spring.mvc.ordermanagement.dto.response;

import java.time.Instant;

/** Represents an empty success response with a status code and timestamp. */
public record EmptySuccessResponse(int status, Instant timestamp) implements Response<Void> {

  /**
   * Constructs an EmptySuccessResponse with the current timestamp.
   *
   * @param status the HTTP status code
   */
  public EmptySuccessResponse {
    if (timestamp == null) {
      timestamp = Instant.now();
    }
  }
}
