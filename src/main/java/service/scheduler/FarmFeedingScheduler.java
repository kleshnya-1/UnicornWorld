package service.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import service.FeedingService;


@RequiredArgsConstructor
public class FarmFeedingScheduler {

  private final FeedingService feedingService;

  @Scheduled(cron = "0 * * * * *")
  public void startFeeding(){
    feedingService.startFeedingAll();
  }


}
