package com.scada.domain;

import java.util.Date;

public class SysFault {
	//����
	private Integer id;
	//�豸���
	private String equipmentId;
	//�豸����
	private String equipmentType;
	//�豸����ʱ��
	private Date equipmentFailureTime;
	//�豸����ԭ��
	private String equipmentFailureReason;
	//�豸��������
	private String equipmentRepairContent;
	//�豸������
	private String equipmentPersonInCharge;
	//�豸����ά����Ա
	private String equipmentMaintenance;
	//�豸�������ʱ��
	private Date equipmentRepairTime;
	//�豸�������
	private Integer eqequipmentRepairCounts;
	//��ע
	private String equipmentRemark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public Date getEquipmentFailureTime() {
		return equipmentFailureTime;
	}
	public void setEquipmentFailureTime(Date equipmentFailureTime) {
		this.equipmentFailureTime = equipmentFailureTime;
	}
	public String getEquipmentFailureReason() {
		return equipmentFailureReason;
	}
	public void setEquipmentFailureReason(String equipmentFailureReason) {
		this.equipmentFailureReason = equipmentFailureReason;
	}
	public String getEquipmentRepairContent() {
		return equipmentRepairContent;
	}
	public void setEquipmentRepairContent(String equipmentRepairContent) {
		this.equipmentRepairContent = equipmentRepairContent;
	}
	public String getEquipmentPersonInCharge() {
		return equipmentPersonInCharge;
	}
	public void setEquipmentPersonInCharge(String equipmentPersonInCharge) {
		this.equipmentPersonInCharge = equipmentPersonInCharge;
	}
	public String getEquipmentMaintenance() {
		return equipmentMaintenance;
	}
	public void setEquipmentMaintenance(String equipmentMaintenance) {
		this.equipmentMaintenance = equipmentMaintenance;
	}
	public Date getEquipmentRepairTime() {
		return equipmentRepairTime;
	}
	public void setEquipmentRepairTime(Date equipmentRepairTime) {
		this.equipmentRepairTime = equipmentRepairTime;
	}
	public Integer getEqequipmentRepairCounts() {
		return eqequipmentRepairCounts;
	}
	public void setEqequipmentRepairCounts(Integer eqequipmentRepairCounts) {
		this.eqequipmentRepairCounts = eqequipmentRepairCounts;
	}
	public String getEquipmentRemark() {
		return equipmentRemark;
	}
	public void setEquipmentRemark(String equipmentRemark) {
		this.equipmentRemark = equipmentRemark;
	}
}
