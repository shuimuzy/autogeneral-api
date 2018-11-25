package com.autogeneral.api.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is Task model for checking if brackets in a string are balanced
 *
 * @author Simon Tian
 */

@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"id"})
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String input;

	@NotBlank
	private boolean isBalanced;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public boolean isBalanced() {
		return isBalanced;
	}

	public void setIsBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}

}
