package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class User {
	private long id;
	private String username;
	private String fullName;
	private String contactNo;
	private String email;
	private String password;
	private String role;
	private String dob;
	
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
