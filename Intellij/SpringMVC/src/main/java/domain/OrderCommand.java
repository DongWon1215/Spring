package domain;

import lombok.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderCommand {
    private List<OrderItem> orderItems;
    private Address address;
}
