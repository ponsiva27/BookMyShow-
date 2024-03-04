package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.PaymentProvider;
import com.example.BookMyShow.Enum.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment  extends BaseModel{

    private String referenceNumber;
    @Enumerated  (EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated (EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

}
