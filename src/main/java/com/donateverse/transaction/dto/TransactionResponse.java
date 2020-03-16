package com.donateverse.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Long id;

    private Long idUser;

    private Long idProduto;

    private Integer status;

    private Date creationDate;

}
