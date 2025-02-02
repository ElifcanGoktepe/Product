package com.elifcan.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    Integer code; // explains types of response to request, varies according to companies
    String message;
    T data;
    Boolean isSuccess;
}
