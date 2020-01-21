package com.hms.model;

/**
 * This is a Bean class used to represent the User.
 *
 * @author Rahul.
 *
 */
public class User {
	private int pkUserId;
	private int fkRoleId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int age;

	/**
	 * Gets the UserId.
	 *
	 * @return userId.
	 */
	public int getPkUserId() {
		return pkUserId;
	}

	/**
	 *
	 * Sets the userId.
	 *
	 * @param userId Integer.
	 */
	public void setPkUserId(int pkUserId) {
		this.pkUserId = pkUserId;
	}

	/**
	 * Gets the roleId.
	 *
	 * @return roleId.
	 */
	public int getFkRoleId() {
		return fkRoleId;
	}

	/**
	 *
	 * Sets the roleId.
	 *
	 * @param roleId Integer.
	 */
	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	/**
	 * Gets the username.
	 *
	 * @return username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 *
	 * Sets the username.
	 *
	 * @param username String.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * Sets the password.
	 *
	 * @param password String.
	 */
	public void setPassword(String password) {
		this.password = password;
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
//		this.password = passwordEncoder.encode(password);
	}

	/**
	 * Gets the firstName.
	 *
	 * @return firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * Sets the firstName.
	 *
	 * @param firstName String.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the lastName.
	 *
	 * @return lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 *
	 * Sets the lastName.
	 *
	 * @param lastName String.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age.
	 *
	 * @return age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 *
	 * Sets the age.
	 *
	 * @param age Integer.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns user as a String.
	 *
	 * @return User as a String.
	 */
	@Override
	public String toString() {
		return "User [pkUserId=" + pkUserId + ", fkRoleId=" + fkRoleId + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", getPkUserId()="
				+ getPkUserId() + ", getFkRoleId()=" + getFkRoleId() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAge()=" + getAge() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
