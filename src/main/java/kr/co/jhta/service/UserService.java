package kr.co.jhta.service;

import org.springframework.stereotype.Service;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.dao.UserRoleDao;
import kr.co.jhta.vo.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	
	// 신규 사용자 등록하기
	public void createUser(User user) {
		
	}
	
	// 사용자 인증하기
	public User login(String email, String password) {
		
		return null;
	}
	
	// 사용자 상세정보 제공하기(보유권한 정보도 같이 조회함)
	public User getUserDetail(int userNo) {
		
		return null;
	}
	
	// 사용자 정보 변경하기	
	public void modifyUser(User user) {

	}
}
