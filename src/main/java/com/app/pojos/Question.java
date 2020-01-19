package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int level;
	
	private String question;
	
	@Lob
	private byte[] image;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String answer;	
	
}
