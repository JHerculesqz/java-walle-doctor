package com.huawei._1_model.healthdata;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * 个人健康数据<br>
 * @author zhangxincheng
 *
 */
@Component
public class HeathData {
	
	@Id
	private String id;
	
	// #region Fields
	
	// 用户名
	private String userName;
	
	// 采集时间
	private String collectTime;
	
	// 身高
	private String height;
	
	// 体重
	private String weight;
	
	// 心率
	private String heartRate;
	
	// 体脂率
	private String bodyFatRate;
	
	// 血压
	private String bloodPressure;
	
	// 呼吸速率
	private String respiratoryRate;
	
	// 体温
	private String Temperature;
	
	// 睡眠时长
	private String sleepHours;
	
	// 睡眠状态
	private String sleepState;
	
	// #endregion
	
	// #region
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getBodyFatRate() {
		return bodyFatRate;
	}

	public void setBodyFatRate(String bodyFatRate) {
		this.bodyFatRate = bodyFatRate;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public String getTemperature() {
		return Temperature;
	}

	public void setTemperature(String temperature) {
		Temperature = temperature;
	}

	public String getSleepHours() {
		return sleepHours;
	}

	public void setSleepHours(String sleepHours) {
		this.sleepHours = sleepHours;
	}

	public String getSleepState() {
		return sleepState;
	}

	public void setSleepState(String sleepState) {
		this.sleepState = sleepState;
	}
	
	// #endregion
	
	// #region Constructor
	public HeathData(){
		
	}
	
	public HeathData(String userName, String collectTime){
		this.userName = userName;
		this.collectTime = collectTime;
	}
	
	// #endregion
	
}
