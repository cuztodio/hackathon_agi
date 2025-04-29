package com.agibank.hackathon.ems.controller.request.oc;

import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class EditarStatusOrdemDeCompraRequest {
    private StatusOrdemDeCompra status;
}
