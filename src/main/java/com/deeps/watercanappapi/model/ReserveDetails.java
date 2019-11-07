package com.deeps.watercanappapi.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Entity
@Table(name = "reserve_List")

public class ReserveDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "User_Id")
	private int userId;
	
	@Column(name = "Date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;

	@Column(name = "Reserved_List")
	private int reservedList;

	@Column(name = "Reserved_Order")
	private int reservedOrder;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "Mobile_Number")
	private Long number;
}
