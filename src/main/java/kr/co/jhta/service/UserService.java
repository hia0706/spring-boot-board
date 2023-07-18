package kr.co.jhta.service;

import kr.co.jhta.vo.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.dao.UserRoleDao;
import kr.co.jhta.vo.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
	
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.getUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("["+email+"]");
		}

		List<UserRole> userRoles = userRoleDao.getUserRolesByUserNo(user.getNo());
		List<String> roleNames = new ArrayList<>();
		for (UserRole role : userRoles) {
			roleNames.add(role.getRoleName());
		}
		user.setRoleNames(roleNames);

		return user;
	}
	
	// 신규 사용자 등록하기
	public void createUser(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setEncryptedPassword(password);

		// 1. 비밀번호를 암호화해서 저장시키기
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setEncryptedPassword(encryptedPassword);

		// 2. 테이블에 사용자 정보 저장하기
		userDao.insertUser(user);

		// 3. 테이블에 사용자 보유권한 저장하기
		UserRole role = new UserRole();
		role.setUser(user);
		role.setRoleName("ROLE_USER");

		userRoleDao.insertUserRole(role);
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
