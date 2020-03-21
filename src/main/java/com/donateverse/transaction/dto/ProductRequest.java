package com.donateverse.transaction.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@ToString
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;

    private Integer amount;

}
