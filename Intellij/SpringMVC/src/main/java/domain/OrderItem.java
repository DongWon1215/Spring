package domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem {

    private String itemId;
    private int number;
    private String remark;
}
