package com.mth.spring.mvc.ordermanagement.dto.response;

import java.time.Instant;

/** Represents an error response with status, error details, and timestamp. */
public record ErrorResponse(int status, ErrorDetail errorDetail, Instant timestamp)
    implements Response<Void> {

  /**
   * Constructs an ErrorResponse with the current timestamp.
   *
   * @param status the status code
   * @param errorDetail the error details
   */
  public ErrorResponse {
    if (timestamp == null) {
      timestamp = Instant.now();
    }
  }
}
