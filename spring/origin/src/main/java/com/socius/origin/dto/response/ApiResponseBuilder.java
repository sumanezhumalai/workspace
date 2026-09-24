package com.socius.origin.dto.response;

/**
 * ApiResponseBuilder
 */
public class ApiResponseBuilder {

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<T>(true, message, data, null);
    }

    public static ApiResponse<Object> error(String message, Object errors) {
        return new ApiResponse<Object>(false, message, null, errors);
    }
}
