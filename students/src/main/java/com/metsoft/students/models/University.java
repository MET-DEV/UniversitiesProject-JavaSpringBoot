package com.metsoft.students.models;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "universities")
public class University {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "universityname")
	@NotBlank(message = "Üniversite adı boş bırakılamaz")
	private String universityName;
	
	@OneToMany(mappedBy = "university")
	@JsonIgnore
	private List<Student> students;
	
	@OneToMany(mappedBy = "university")
	@JsonIgnore
	private List<Academician> academicians;
	
}
