package com.example.weblor.common;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(UserPrincipal.getUsernameCurrent());
	}

}
