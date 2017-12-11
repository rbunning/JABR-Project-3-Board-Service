package com.revature.project3.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SCRUM_USER")
public class ScrumUser implements Serializable, UserDetails {

	private static final long serialVersionUID = -1738765309975039165L;
	@JsonIgnore
	@OneToMany(mappedBy = "scrumUser")
	private Set<BoardUserJoin> boardUserJoins;

	@Id
	@Column(name = "SU_ID")
	@SequenceGenerator(allocationSize = 1, sequenceName = "SCRUM_USER_SEQ", name = "SU_SEQ")
	@GeneratedValue(generator = "SU_SEQ", strategy = GenerationType.SEQUENCE)
	private int scrumUserId;

	@ManyToOne
	@JoinColumn(name = "RT_ID")
	private RoleType roleType;

	@Column(name = "SU_FN")
	private String scrumUserFirstname;

	@Column(name = "SU_LN")
	private String scrumUserLastname;

	@Column(name = "SU_USERNAME")
	private String scrumUserUsername;

	@Column(name = "SU_PASSWORD")
	private transient String scrumUserPassword;

	public ScrumUser() {
		super();
	}

	public ScrumUser(String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUserUsername = scrumUserUsername.trim();
		this.scrumUserPassword = scrumUserPassword.trim();
	}

	public ScrumUser(int scrumUserId, RoleType roleType, String scrumUserFirstname, String scrumUserLastname,
			String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUserId = scrumUserId;
		this.roleType = roleType;
		this.scrumUserFirstname = scrumUserFirstname;
		this.scrumUserLastname = scrumUserLastname;
		this.scrumUserUsername = scrumUserUsername;
		this.scrumUserPassword = scrumUserPassword;
	}

	public int getScrumUserId() {
		return scrumUserId;
	}

	public void setScrumUserId(int scrumUserId) {
		this.scrumUserId = scrumUserId;
	}

	public RoleType getRoleId() {
		return roleType;
	}

	public void setRoleId(RoleType roleId) {
		this.roleType = roleId;
	}

	public String getScrumUserFirstname() {
		return scrumUserFirstname;
	}

	public void setScrumUserFirstname(String scrumUserFirstname) {
		this.scrumUserFirstname = scrumUserFirstname;
	}

	public String getScrumUserLastname() {
		return scrumUserLastname;
	}

	public void setScrumUserLastname(String scrumUserLastname) {
		this.scrumUserLastname = scrumUserLastname;
	}

	public String getScrumUserUsername() {
		return scrumUserUsername;
	}

	public void setScrumUserUsername(String scrumUserUsername) {
		this.scrumUserUsername = scrumUserUsername;
	}

	public String getScrumUserPassword() {
		return scrumUserPassword;
	}

	public void setScrumUserPassword(String scrumUserPassword) {
		this.scrumUserPassword = scrumUserPassword;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Set<BoardUserJoin> getBoardUserJoins() {
		return boardUserJoins;
	}

	public void setBoardUserJoins(Set<BoardUserJoin> boardUserJoins) {
		this.boardUserJoins = boardUserJoins;
	}

	@Override
	public String toString() {
		return "ScrumUser [boardUserJoins=" + boardUserJoins + ", scrumUserId=" + scrumUserId + ", roleType=" + roleType
				+ ", scrumUserFirstname=" + scrumUserFirstname + ", scrumUserLastname=" + scrumUserLastname
				+ ", scrumUserUsername=" + scrumUserUsername + ", scrumUserPassword=" + scrumUserPassword + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getScrumUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getScrumUserUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
