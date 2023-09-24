package com.query.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.example.mapper.InfoMapper;
import com.query.example.repository.InfoRepository;
import com.query.example.vo.FirstVO;

@Service
public class ExampleService {
  @Autowired
  private InfoRepository infoRepository;
  @Autowired
  private InfoMapper infoMapper;
  
  public List<FirstVO> beforeFirst(Integer infoId) {
    return this.infoRepository.findByInfoIdBeforeFirst(infoId);
  }

  public List<FirstVO> afterFirst(Integer infoId) {
    return this.infoMapper.findByInfoidTuningFirst(infoId);
  }
}
