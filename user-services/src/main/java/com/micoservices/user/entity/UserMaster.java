package com.micoservices.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Application user
 * 
 * @author Prasad Pansare
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_master")
public class UserMaster {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "about")
	private String about;

	@Column(name = "password")
	private String password;
}
