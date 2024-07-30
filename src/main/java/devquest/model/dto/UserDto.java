// src\main\java\devquest\model\dto\UserDto.java

package devquest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, ToString, RequiredArgsConstructor(final 필드나 @NonNull이 붙은 필드에 대한 생성자 생성), EqualsAndHashCode
@NoArgsConstructor // 인자가 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드에 대한 인자를 받는 생성자 생성
@Builder // 빌더 패턴 적용 가능하게 함
public class UserDto {
}
