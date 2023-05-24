package com.pirai.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "audit")
@SQLDelete(sql = "UPDATE audit SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Audit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "created_at")
	private String createdAt;
	
	@Column(name = "modified_by")
	private Long modifiedBy;
	
	@Column(name = "modified_at")
	private String modifiedAt;

	@Column(name = "is_deleted")
    private Boolean isDeleted = false;
    
  
}
