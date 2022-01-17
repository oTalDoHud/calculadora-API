package com.calc.web.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.calc.web.model.entities.enums.MathType;

@Entity
@Table(name = "TB_Operation")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double number1;
	
	private Double number2;
	
	@Enumerated(EnumType.STRING)
	private MathType type;
	
	private Double result;
	
	@ManyToOne
	@JoinColumn(name = "Users_Id")
	private User user;

	public Operation() {

	}
	
	public Operation(Double number1, Double number2, MathType type, 
			User user) {
		this.number1 = number1;
		this.number2 = number2;
		this.type = type;
		this.user = user;
		setResult();
	}
	
	public Operation(Integer id, Double number1, Double number2, 
			MathType type, User user) {
		super();
		this.id = id;
		this.number1 = number1;
		this.number2 = number2;
		this.type = type;
		this.user = user;
		setResult();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNumber1() {
		return number1;
	}

	public void setNumber1(Double number1) {
		this.number1 = number1;
	}

	public Double getNumber2() {
		return number2;
	}

	public void setNumber2(Double number2) {
		this.number2 = number2;
	}

	public MathType getType() {
		return type;
	}

	public void setType(MathType type) {
		this.type = type;
	}

	public Double getResult() {
		return result;
	}

	public void setResult() {
		if (type == MathType.SUM) {
			this.result = number1 + number2;
		}
		else if (type == MathType.SUBTRACTION) {
			this.result = number1 - number2;
		}
		else if (type == MathType.MULTIPLICATION) {
			this.result = number1 * number2;
		}
		else if (type == MathType.DIVISION) {
			this.result = number1 / number2;
		}
//		else {
//			this.result = 125.99;
//		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operation other = (Operation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
