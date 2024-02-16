package in.dev.gmsk.serviceImpl;

import in.dev.gmsk.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("admin") && password.equals("dummy");
	}

}
