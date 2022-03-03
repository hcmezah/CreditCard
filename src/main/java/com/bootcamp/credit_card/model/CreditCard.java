package com.bootcamp.credit_card.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "credit_card")
public class CreditCard {

    @Id
    private String id;
    private String nroCuenta;
    private String nroDocumento;
    private double saldo;
    private double limiteConsumo;
    private double cantidadConsumo;
}
