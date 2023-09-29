package com.query.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.example.dto.DeliveryDTO;
import com.query.example.entities.DeliveryEntity;
import com.query.example.mapper.ConfigMapper;
import com.query.example.mapper.DeliveryMapper;
import com.query.example.mapper.InfoMapper;
import com.query.example.repository.DeliveryRepository;
import com.query.example.repository.QConfigRepository;
import com.query.example.repository.QInfoRepository;
import com.query.example.vo.FirstVO;
import com.query.example.vo.SecondVO;

@Service
public class ExampleService {
  @Autowired
  private QInfoRepository infoRepository;
  @Autowired
  private QConfigRepository configRepository;
  @Autowired
  private DeliveryRepository deliveryRepository;
  @Autowired
  private InfoMapper infoMapper;
  @Autowired
  private ConfigMapper configMapper;
  @Autowired
  private DeliveryMapper deliveryMapper;
  
  public List<FirstVO> beforeFirst(Integer infoId) {
    return this.infoRepository.findByInfoIdBeforeFirst(infoId);
  }

  public List<FirstVO> afterFirst(Integer infoId) {
    return this.infoMapper.findByInfoidTuningFirst(infoId);
  }

  public List<SecondVO> beforeSecond(Long configId) {
    return this.configMapper.findByIdBeforeSecond(configId);
  }

  public List<SecondVO> afterSecond(Long configId) {
    return this.configRepository.findByIdTuningSecond(configId);
  }

  public DeliveryDTO beforInsertWhere(DeliveryDTO body) {
    if (this.deliveryRepository.existsByTitle(body.getTitle())) {
      return null;
    }
    DeliveryEntity delivery = DeliveryEntity
      .builder()
      .title(body.getTitle())
      .configId(body.getConfigId())
      .build();
    this.deliveryRepository.save(delivery);
    body.setId(delivery.getId());
    return body;
  }

  public DeliveryDTO afterInsertWhere(DeliveryDTO body) {
    this.deliveryMapper.insertByTitle(body);
    if(body.getId() == 0 ){
      return null;
    }
    return body;
  }
}
