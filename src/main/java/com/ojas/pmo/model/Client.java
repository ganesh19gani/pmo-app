package com.ojas.pmo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/*
 * @Author
 * @Akshaya Mahanty
 * */

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CREATE_DATE")
	private Date createDate;
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;
	@Column(name = "RECDELETE")
	private int softdelete;


	

	
}
