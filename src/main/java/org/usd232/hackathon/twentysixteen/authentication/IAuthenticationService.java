package org.usd232.hackathon.twentysixteen.authentication;

public interface IAuthenticationService {
	/**
	 * Determines if the user with a specified token is authenticated currently
	 * 
	 * @param token
	 *            The authentication token
	 * @return If the user is authenticated
	 */
	public boolean isAuthenticated(String token);

	/**
	 * Gets the information about a user authenticated with a token
	 * 
	 * @param token
	 *            The authentication token
	 * @return The user information
	 */
	public UserInfo getInfo(String token);

	/**
	 * Logs out the user with the specified authentication token
	 * 
	 * @param info
	 *            The authentication token
	 */
	public void logoutUser(String token);

	/**
	 * Logs in the user (callback from the specified uri)
	 * 
	 * @param uri
	 *            The uri the user connected to
	 * @return The new token for the user
	 */
	public String loginUser(String uri);

	/**
	 * Gets the uri the user should be redirected to in order to log in
	 * 
	 * @param domain
	 *            The domain name the client connected to
	 * @return The uri
	 */
	public String getLoginUri(String domain);
}
