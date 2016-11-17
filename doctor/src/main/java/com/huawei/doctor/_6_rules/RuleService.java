package com.huawei.doctor._6_rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei._1_model.sickness.SicknessProcessRepository;
import com.huawei._1_model.user.User;
import com.huawei.doctor._6_rules.provider.MainProvider;

@Component
public class RuleService {
	// #region Fields

	@Autowired
	public SicknessProcessRepository sicknessRepo;

	// #endregion

	// #region updateSickness

	public void updateSickness(User oUser) {
		MainProvider.updateSickness(oUser, sicknessRepo);
	}

	// #endregion

	// #region startXXX

	public String startWarn(String strUsername) {
		return MainProvider.startWarn(strUsername, sicknessRepo);
	}

	public String startEmergency(String strUsername) {
		return MainProvider.startEmergency(strUsername, sicknessRepo);
	}

	// #endregion
}
