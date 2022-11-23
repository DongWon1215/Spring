package domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequest {
    private LocalDate date;

//    public void setDate(String date)
//    {
//        this.date = LocalDate.parse((date));
//    }
}
