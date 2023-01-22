package service;

import repository.UnicornRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnicornReadService {

  private final UnicornRepository unicornRepository;

  public void readToBroker(){

  }



}
