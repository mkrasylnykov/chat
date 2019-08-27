/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author mkrasilnikov
 */

@Entity
@Table(name="account")
public class Account implements Serializable {

	@Id
    @GeneratedValue
    @Column(name="id", nullable=false)
	private Long id;
	
    @Column(name="firstName", length=128, nullable=true)
	private String firstName;
	
    @Column(name="lastName", length=128, nullable=true)
	private String lastName;
	
    @Column(name="zip", length=128, nullable=true)
	private String zip;
	
    @Column(name="gender", length=128, nullable=true)
	private String gender;
	
    @Column(name="birthday", length=128, nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	
    @Column(name="email", length=128, nullable=false)
	private String email;

    @Column(name="username", length=70, nullable=false)
	private String username;
    
    @Column(name="password", length=70, nullable=false)
	private String password;

    @Column(name="enabled", length=70, nullable=false)
	private Boolean enabled;

	public Account() {
	}
		
	public Date getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getGender() {
		return gender;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

        public String getUsername() {
		return username;
	}
        
	public String getPassword() {
		return password;
	}
        
	public Boolean getEnabled() {
		return enabled;
	}

	public String getZip() {
		return zip;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}
        
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
        
	public void setZip(String zip) {
		this.zip = zip;
	}
  
}
