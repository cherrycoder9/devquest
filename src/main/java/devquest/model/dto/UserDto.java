// src\main\java\devquest\model\dto\UserDto.java

package devquest.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴 적용 가능하게 함
public class UserDto {
    private Integer userNo; // 사용자 고유번호, 기본키
    private String userId; // 사용자 계정 아이디 (로그인 아이디)
    private String email; // 사용자 이메일
    private String password; // 사용자 비밀번호
    private String airPassword; // 6개의 숫자 비밀번호 (화면 잠금 용도)
    private String nickname; // 사용자의 화면 표시용 닉네임
    private Boolean emailVerified; // 사용자 이메일 인증여부
    private Boolean isEmployer; // 고용주인가?
    private Boolean isActive; // 계정 활성화 상태
    private String createdAt; // 계정 생성 시간
    private String updatedAt; // 계정 수정 시간
} // End of UserDto class
