package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

  private SpeakerRepository speakerRepository;

  public SpeakerServiceImpl() {}

  public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
    this.speakerRepository = speakerRepository;
  }

  @Override
  public List<Speaker> findAll() {
    return speakerRepository.findAll();
  }

  @Autowired
  public void setSpeakerRepository(SpeakerRepository speakerRepository) {
    this.speakerRepository = speakerRepository;
  }

}