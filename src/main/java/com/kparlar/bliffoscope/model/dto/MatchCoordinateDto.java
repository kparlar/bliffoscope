package com.kparlar.bliffoscope.model.dto;

public class MatchCoordinateDto {
	String targetType;
	int x;
	int y;
	double confidencepercentage;

	public MatchCoordinateDto(){

	}
	public MatchCoordinateDto(String targetType, int x, int y,
							  double confidencepercentage) {
		this.targetType = targetType;
		this.x = x;
		this.y = y;
		this.confidencepercentage = confidencepercentage;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getConfidencepercentage() {
		return confidencepercentage;
	}

	public void setConfidencepercentage(double confidencepercentage) {
		this.confidencepercentage = confidencepercentage;
	}
}
