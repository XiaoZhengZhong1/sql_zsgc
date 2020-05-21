package com.sql_zsgc.pojo;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "szygdl", catalog = "test")
public class Szygdl {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mseq")
	@SequenceGenerator(name="mseq",sequenceName="seq_szygdl",allocationSize=1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ppmaterial_barcoder_id")
	private int ppmaterialBarcoderId;

	@Column(name = "pporder_h_id")
	private String pporderHId;

	@Column(name = "material_id")
	private String materialId;


	@Column(name = "material_desc")
	private String materialDesc;

	@Column(name = "serial_no")
	private String serialNo;


	@Column(name = "baccoder_id")
	private String baccoderId;

	@Column(name = "plant_english_id")
	private String plantEnglishId;

	@Column(name = "plant_desc")
	private String plantDesc;

	@Column(name = "usage_id")
	private String usageId;

	@Column(name = "margin_id")
	private String marginId;

	@Column(name = "usage_data")
	private String usageData;

	@Column(name = "uustandardinfo")
	private String uustandardinfo;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "check_info")
	private String checkInfo;

	@Column(name = "reserve")
	private String reserve;

	@Column(name = "material_special")
	private String materialSpecial;

	@Column(name = "cety")
	 private Double cety;

	@Column(name = "unit")
	 private String  unit;

	@Column(name = "pporder_date")
	 private Date pporderDate;

	@Column(name = "sta")
	 private String sta;

	@Column(name = "print_count")
	 private Double printCount;

	public int getPpmaterialBarcoderId() {
		return ppmaterialBarcoderId;
	}

	public void setPpmaterialBarcoderId(int ppmaterialBarcoderId) {
		this.ppmaterialBarcoderId = ppmaterialBarcoderId;
	}

	public String getPporderHId() {
		return pporderHId;
	}

	public void setPporderHId(String pporderHId) {
		this.pporderHId = pporderHId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getBaccoderId() {
		return baccoderId;
	}

	public void setBaccoderId(String baccoderId) {
		this.baccoderId = baccoderId;
	}

	public String getPlantEnglishId() {
		return plantEnglishId;
	}

	public void setPlantEnglishId(String plantEnglishId) {
		this.plantEnglishId = plantEnglishId;
	}

	public String getPlantDesc() {
		return plantDesc;
	}

	public void setPlantDesc(String plantDesc) {
		this.plantDesc = plantDesc;
	}

	public String getUsageId() {
		return usageId;
	}

	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}

	public String getMarginId() {
		return marginId;
	}

	public void setMarginId(String marginId) {
		this.marginId = marginId;
	}

	public String getUsageData() {
		return usageData;
	}

	public void setUsageData(String usageData) {
		this.usageData = usageData;
	}

	public String getUustandardinfo() {
		return uustandardinfo;
	}

	public void setUustandardinfo(String uustandardinfo) {
		this.uustandardinfo = uustandardinfo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public String getMaterialSpecial() {
		return materialSpecial;
	}

	public void setMaterialSpecial(String materialSpecial) {
		this.materialSpecial = materialSpecial;
	}

	public Double getCety() {
		return cety;
	}

	public void setCety(Double cety) {
		this.cety = cety;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getPporderDate() {
		return pporderDate;
	}

	public void setPporderDate(Date pporderDate) {
		this.pporderDate = pporderDate;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public Double getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Double printCount) {
		this.printCount = printCount;
	}
}
