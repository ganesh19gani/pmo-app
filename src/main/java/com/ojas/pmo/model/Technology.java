package com.ojas.pmo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/*
 * @Author
 * @Akshaya Mahanty
 * */

@Entity
@Table(name = "technology")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", unique = true, nullable = false)
	private String name;
	@Column(name = "CREATE_DATE")
	private Date createDate;
	@Column(name = "RECDELETE")
	private int softdelete;


	
}
