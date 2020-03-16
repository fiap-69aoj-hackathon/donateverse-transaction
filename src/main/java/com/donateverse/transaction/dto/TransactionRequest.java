package com.donateverse.transaction.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@Getter
@ToString
public class TransactionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idUser;

    @NotNull
    private Long idProduto;

    @NotNull
    private Integer status;

}
