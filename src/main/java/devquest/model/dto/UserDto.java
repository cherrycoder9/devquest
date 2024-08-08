// devquest\src\main\java\devquest\model\dto\UserDto.java

package devquest.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class UserDto {
    private int userNo;
    private String loginId;
    private String password;
} // End of UserDto class
