package model.entity.model;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public class MealEntity implements Meal{

  //todo add Dishes
  @Getter
  @Setter
  private Map<Nutrient, Integer> nutrientGramsMap;

}
