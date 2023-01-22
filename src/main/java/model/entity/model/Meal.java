package model.entity.model;

import java.util.Map;

public interface Meal {
  double proteinWeightRate = 0.25;
  double fatWeightRate = 0.25;
  double carbonWeightRate = 0.25;
  Map<Nutrient, Double> nutrientWeightRateMap =
      Map.of(
          Nutrient.PROTEIN, proteinWeightRate,
          Nutrient.FAT, fatWeightRate,
          Nutrient.CARBON, carbonWeightRate);

  Map<Nutrient, Integer> getNutrientGramsMap();

  default Map<Nutrient, Double> getMassRateMap() {
    return nutrientWeightRateMap;
  }
}
