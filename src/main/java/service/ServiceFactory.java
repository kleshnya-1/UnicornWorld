package service;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.behavior.Feedable;
import model.entity.animal.CatEntity;
import model.entity.animal.RaccoonEntity;
import model.entity.animal.UnicornEntity;
import org.springframework.context.ApplicationContext;

@RequiredArgsConstructor
public class ServiceFactory {

  private final ApplicationContext applicationContext;

  private static final Map<Class<? extends AbstractAnimal>, Class<? extends AbstractAnimalService>> SERVICE_MAP = new HashMap<>();

  static {
    SERVICE_MAP.put(CatEntity.class, CatService.class);
    SERVICE_MAP.put(RaccoonEntity.class, RaccoonService.class);
    SERVICE_MAP.put(UnicornEntity.class, UnicornService.class);
  }

  public AbstractAnimalService getService(Class<? extends AbstractAnimal> c) {
    return applicationContext.getBean(SERVICE_MAP.get(c));
  }
}
