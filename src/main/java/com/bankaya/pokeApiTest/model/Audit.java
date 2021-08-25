package com.bankaya.pokeApiTest.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
@Data
@Builder
/**
 * model tu build audit
 * 
 *
 */
public class Audit {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String originIp;
	@CreationTimestamp
	private Date dateRequest;
	@Column
	private String method;

}