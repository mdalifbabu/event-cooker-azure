package com.example.eventcooker.models;

import com.example.eventcooker.masterdata.models.geography.Address;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;
}
