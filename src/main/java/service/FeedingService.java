package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import model.behavior.Feedable;
import model.entity.animal.CatEntity;
import model.entity.animal.RaccoonEntity;
import model.entity.animal.UnicornEntity;

@RequiredArgsConstructor
public class FeedingService {

  private final ServiceFactory serviceFactory;

  public void startFeedingAll(){
    List<AbstractAnimal> animalsToFeed = selectAnimals(CatEntity.class, RaccoonEntity.class, UnicornEntity.class);

  }

  private List<AbstractAnimal> selectAnimals(Class<? extends AbstractAnimal>... classes) {
    return Arrays.stream(classes).flatMap(this::readAmimalStream).toList();
  }

  // TODO rename (ALaptev 18.01.2023)
  private Stream<AbstractAnimal> readAmimalStream(Class<? extends AbstractAnimal> c) {
    return serviceFactory.getService(c).readAllHungryAnimals().stream();
  }

}
