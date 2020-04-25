package com.postgres.hibernate.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle_details")
public class VehicleEntity implements Serializable {

	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_Id", unique = true, nullable = false)
	private Integer vehicleId; 
	
	@Column(name = "vehicle_no", unique = true, nullable = false)
	private String vehicleNo; 
	
	private String color;
	
	@Column(name = "no_of_wheels")
	private Integer noOfWheels;
	
	
	@ManyToOne(cascade= {
			CascadeType.PERSIST, 
			CascadeType.MERGE,
			CascadeType.DETACH, 
			CascadeType.REFRESH
			})
	@JoinColumn(name="owner_details_id")
	private OwnerEntity owner;


	public VehicleEntity() {
	}


	public VehicleEntity(String vehicleNo, String color, Integer noOfWheels) {
		this.vehicleNo = vehicleNo;
		this.color = color;
		this.noOfWheels = noOfWheels;
	}
	
	public Integer getVehicleId() {
		return vehicleId;
	}


	public void setVehicleNo(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}


	public String getVehicleNo() {
		return vehicleNo;
	}


	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Integer getNoOfWheels() {
		return noOfWheels;
	}


	public void setNoOfWheels(Integer noOfWheels) {
		this.noOfWheels = noOfWheels;
	}


	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public OwnerEntity getOwner() {
		return owner;
	}

	public void setOwner(OwnerEntity owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [vehicleNo=");
		builder.append(vehicleNo);
		builder.append(", color=");
		builder.append(color);
		builder.append(", noOfWheels=");
		builder.append(noOfWheels);
		builder.append("]");
		return builder.toString();
	}
}
