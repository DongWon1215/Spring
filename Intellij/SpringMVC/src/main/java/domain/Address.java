package domain;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String zipcode;
    private String address1;
    private String address2;
}
