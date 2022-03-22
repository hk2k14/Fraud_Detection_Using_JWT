package com.mycompany.app.customer;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FraudCheckResponse{

    public Boolean isFraudster;
}
