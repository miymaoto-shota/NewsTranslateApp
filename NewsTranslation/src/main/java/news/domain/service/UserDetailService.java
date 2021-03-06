package news.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import news.domain.model.AccountDataEntity;
import news.domain.repository.AccountDataRepository;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	AccountDataRepository accountDataRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountDataEntity accountDataEntity = accountDataRepository.findByUserName(username);

		if (accountDataEntity == null) {
			throw new UsernameNotFoundException("This user is not found:" + username);
		}

		// 権限
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		grantList.add(authority);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails userDetails = (UserDetails) new User(accountDataEntity.getUserName(),
				encoder.encode(accountDataEntity.getPassword()), grantList);

		return userDetails;
	}

}
