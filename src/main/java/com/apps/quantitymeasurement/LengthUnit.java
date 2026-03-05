package com.apps.quantitymeasurement;

public enum LengthUnit {
	FEET(12.0), INCHES(1.0), YARDS(36.0), CENTIMETERS(0.393700787);

	private final double conversionFactor;

	LengthUnit(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public double getConversionFactor() {
		return this.conversionFactor;
	}

	public double convertToBaseUnit(double value) {
		double convertedValue = value * conversionFactor;
		return roundUpToTwoPlace(convertedValue);
	}

	public double convertFromBaseUnit(double value) {
		double convertedValue = value / conversionFactor;
		return roundUpToTwoPlace(convertedValue);
	}

	private double roundUpToTwoPlace(double value) {
		return Math.round(value * 100.0) / 100.0;
	}
}
