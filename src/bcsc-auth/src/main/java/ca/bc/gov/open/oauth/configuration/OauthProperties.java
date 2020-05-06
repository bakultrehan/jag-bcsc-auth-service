package ca.bc.gov.open.oauth.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * BCSC OAUTH properties file object.
 *
 * @See EcrcServicesImpl for example usage.
 *
 * @author sivakaruna
 *
 */
@ConfigurationProperties(prefix = "oauth")
public class OauthProperties {

	private String serverPort;

	// OAUTH Properties
	private String idp;
	private String clientId;
	private String tokenPath;
	private String userinfoPath;
	private String authorizePath;
	private String wellKnown;
	private int bcscTimeout;

	// JWT properties
	private String jwtSecret;
	private String jwtAuthorizedRole;
	private int jwtExpiry;
	private String jwtHeader;
	private String jwtPrefix;

	// Basic Authentication
	private String username;
	private String password;

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getIdp() {
		return idp;
	}

	public void setIdp(String idp) {
		this.idp = idp;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getJwtExpiry() {
		return jwtExpiry;
	}

	public void setJwtExpiry(int jwtExpiry) {
		this.jwtExpiry = jwtExpiry;
	}

	public String getTokenPath() {
		return tokenPath;
	}

	public void setTokenPath(String tokenPath) {
		this.tokenPath = tokenPath;
	}

	public String getUserinfoPath() {
		return userinfoPath;
	}

	public void setUserinfoPath(String userinfoPath) {
		this.userinfoPath = userinfoPath;
	}

	public String getAuthorizePath() {
		return authorizePath;
	}

	public void setAuthorizePath(String authorizePath) {
		this.authorizePath = authorizePath;
	}

	public String getWellKnown() {
		return wellKnown;
	}

	public void setWellKnown(String wellKnown) {
		this.wellKnown = wellKnown;
	}

	public int getBcscTimeout() {
		return bcscTimeout;
	}

	public void setBcscTimeout(int bcscTimeout) {
		this.bcscTimeout = bcscTimeout;
	}

	public String getJwtSecret() {
		return jwtSecret;
	}

	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	public String getJwtAuthorizedRole() {
		return jwtAuthorizedRole;
	}

	public void setJwtAuthorizedRole(String jwtAuthorizedRole) {
		this.jwtAuthorizedRole = jwtAuthorizedRole;
	}

	public String getJwtHeader() {
		return jwtHeader;
	}

	public void setJwtHeader(String jwtHeader) {
		this.jwtHeader = jwtHeader;
	}

	public String getJwtPrefix() {
		return jwtPrefix;
	}

	public void setJwtPrefix(String jwtPrefix) {
		this.jwtPrefix = jwtPrefix;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
