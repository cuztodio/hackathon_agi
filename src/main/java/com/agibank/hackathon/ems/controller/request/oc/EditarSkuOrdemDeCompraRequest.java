package com.agibank.hackathon.ems.controller.request.oc;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class EditarSkuOrdemDeCompraRequest {
    private String sku;
}
