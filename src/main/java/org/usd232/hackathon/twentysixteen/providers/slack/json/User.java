package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class User {
	private String id;
	private String team_id;
	private String name;
	private boolean deleted;
	private String status;
	private String color;
	private String real_name;
	private String tz;
	private String tz_label;
	private long tz_offset;
	private Profile profile;
	private boolean is_admin;
	private boolean is_owner;
	private boolean has_2fa;
	private boolean has_files;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return team_id;
	}

	public void setTeamId(String team_id) {
		this.team_id = team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRealName() {
		return real_name;
	}

	public void setRealName(String real_name) {
		this.real_name = real_name;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getTzLabel() {
		return tz_label;
	}

	public void setTzLabel(String tz_label) {
		this.tz_label = tz_label;
	}

	public long getTzOffset() {
		return tz_offset;
	}

	public void setTzOffset(long tz_offset) {
		this.tz_offset = tz_offset;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isIsAdmin() {
		return is_admin;
	}

	public void setIsAdmin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	public boolean isIsOwner() {
		return is_owner;
	}

	public void setIsOwner(boolean is_owner) {
		this.is_owner = is_owner;
	}

	public boolean isHas2fa() {
		return has_2fa;
	}

	public void setHas2fa(boolean has_2fa) {
		this.has_2fa = has_2fa;
	}

	public boolean isHasFiles() {
		return has_files;
	}

	public void setHasFiles(boolean has_files) {
		this.has_files = has_files;
	}
}
