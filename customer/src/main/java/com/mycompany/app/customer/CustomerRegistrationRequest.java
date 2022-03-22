package com.mycompany.app.customer;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationRequest {
    private String firstName ;
    private String lastName ;
    private String email ;
}
