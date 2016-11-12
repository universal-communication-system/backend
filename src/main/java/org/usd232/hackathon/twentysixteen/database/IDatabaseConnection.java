package org.usd232.hackathon.twentysixteen.database;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import org.usd232.hackathon.twentysixteen.authentication.UserInfo;
import org.usd232.hackathon.twentysixteen.model.Account;

public interface IDatabaseConnection {
	public void deleteAccount(UserInfo user, UUID account);

	public UUID addAccount(UserInfo user, String data);

	public String getAccountData(UserInfo user, UUID account);

	public List<Account> getAccounts(UserInfo user);

	public Account getAccount(UserInfo user, UUID account);

	public void afterLogin(UserInfo user);

	public ResultSet query(String query);

	public void statement(String statement);
}
