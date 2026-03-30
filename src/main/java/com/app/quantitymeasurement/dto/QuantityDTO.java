package com.app.quantitymeasurement.dto;

import java.util.logging.Logger;

import com.app.quantitymeasurement.unit.LengthUnit;
import com.app.quantitymeasurement.unit.TemperatureUnit;
import com.app.quantitymeasurement.unit.VolumeUnit;
import com.app.quantitymeasurement.unit.WeightUnit;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityDTO {
	private static final Logger logger = Logger.getLogger(QuantityDTO.class.getName());

	@NotNull
	public double value;

	@NotNull
	public String unit;

	@NotNull
	@Pattern(regexp = "LengthUnit|VolumeUnit|WeightUnit|TemperatureUnit", message = "Measurement type must be one of...")
	public String measurementType;

//  Custom validation to check if unit matches measurement type
	@AssertTrue(message = "Unit must be valid for the specified measurement type")
	public boolean isValidUnit() {
		logger.info("Validating unit: " + unit + " for measurement type: " + measurementType);
		try {
			switch (measurementType) {
			case "LengthUnit":
				LengthUnit.valueOf(unit);
				break;

			case "VolumeUnit":
				VolumeUnit.valueOf(unit);
				break;

			case "WeightUnit":
				WeightUnit.valueOf(unit);
				break;

			case "TemperatureUnit":
				TemperatureUnit.valueOf(unit);
				break;

			default:
				return false;
			}

		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

}
