package model.entity.animal;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import model.attributes.Magic;
import model.attributes.UniName;
import model.attributes.UniWeight;
import model.behavior.Feedable;
import model.behavior.Scalable;
import model.entity.PersistableEntity;
import model.entity.model.Meal;
import model.entity.model.Nutrient;
import service.AbstractAnimal;

@Getter
@Setter
public class UnicornEntity extends PersistableEntity implements Scalable, AbstractAnimal {

  private UniName name;
  private LocalDate birthday;
  private UniWeight weight;
  private Magic magic;

  @Override
  public void toFeed(Meal meal) {
    UniWeight weightBeforeFeed = getWeight();
    long addedWeight = parseMeal(meal);
    weightBeforeFeed.setWeightGrams(weightBeforeFeed.getWeightGrams() + addedWeight);
  }

  private long parseMeal(Meal meal) {
    Map<Nutrient, Integer> nutrionMap = meal.getNutrientGramsMap();

    // the value could be separated from Meal interface;
    Map<Nutrient, Double> massRateMap = meal.getMassRateMap();

    return (long) (getMassCalculation(Nutrient.PROTEIN, nutrionMap, massRateMap)
        + getMassCalculation(Nutrient.FAT, nutrionMap, massRateMap)
        + getMassCalculation(Nutrient.CARBON, nutrionMap, massRateMap));
  }

  private double getMassCalculation(Nutrient nutrient,
                                    Map<Nutrient, Integer> nutrionMap,
                                    Map<Nutrient, Double> massRateMap) {
    Integer nutritionMass = nutrionMap.get(nutrient);
    Double digestibility = massRateMap.get(nutrient);
    return Optional.ofNullable(nutritionMass).orElse(0)
        * Optional.ofNullable(digestibility).orElse((double) 0);
  }
}
