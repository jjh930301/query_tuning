package com.query.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.query.example.entities.QConfigEntity;
import com.query.example.entities.QDeliveryEntity;
import com.query.example.entities.QInfoEntity;
import com.query.example.vo.FirstVO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class QInfoRepository{
  @Autowired
  private JPAQueryFactory jpaQueryFactory;

  public List<FirstVO> findByInfoIdBeforeFirst(Integer infoId) {
    QInfoEntity info = new QInfoEntity("info");
    QDeliveryEntity delivery = new QDeliveryEntity("delivery");
    QConfigEntity config = new QConfigEntity("config");
    return jpaQueryFactory
      .select(
        Projections.constructor(
          FirstVO.class, 
          info.id.as("id"),
          info.serviceId.as("serviceId"),
          info.address.as("address"),
          info.addressA.as("addressA"),
          info.addressN.as("addressN"),
          info.createdAt.as("createdAt"),
          delivery.title.as("title")
        )
      )
      .from(info)
      .join(config).on(config.infoId.eq(info.serviceId))
      .join(delivery).on(delivery.id.eq(config.deliveryId))
      .where(info.id.eq((long) infoId))
      .orderBy(info.createdAt.desc())
      .fetch();
  }
}
