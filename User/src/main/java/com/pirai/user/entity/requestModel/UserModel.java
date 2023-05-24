package com.pirai.user.entity.requestModel;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class UserModel {

	private String name;
	
	private String email;
	
	private String mobileNo;
	
	private String userName;
	
	private Long roleId;
	
	private Long auditingId;
	
	private Boolean isDeleted = false;
	
	private Boolean isActive = true;
}
