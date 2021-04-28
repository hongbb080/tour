package tour.dto;

import lombok.Data;

// 사용자 정보 Dto
@Data
public class UserDto {
	private int num;
	private String userEmail;
	private String userId;
	private String userPw;
	private String nickname;
	private String joinedDate;

}
