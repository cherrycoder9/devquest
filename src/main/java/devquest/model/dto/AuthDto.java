// src\main\java\devquest\model\dto\AuthDto.java

package devquest.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴 적용 가능하게 함
public class AuthDto {
    Integer tempVar;
} // End of AuthDto class
