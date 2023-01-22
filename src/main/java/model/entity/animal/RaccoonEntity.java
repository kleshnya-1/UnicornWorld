package model.entity.animal;

import lombok.Getter;
import lombok.Setter;
import model.attributes.UniWeight;
import model.behavior.Feedable;
import model.behavior.Scalable;
import model.entity.model.Meal;
import service.AbstractAnimal;

public class RaccoonEntity implements Scalable, AbstractAnimal {

  @Getter
  @Setter
  private UniWeight weight;

  @Override
  public void toFeed(Meal meal) {

  }
}
