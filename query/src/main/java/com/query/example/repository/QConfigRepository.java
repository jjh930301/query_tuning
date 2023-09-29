package com.query.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.query.example.entities.QConfigEntity;
import com.query.example.entities.QDeliveryEntity;
import com.query.example.entities.QInfoEntity;
import com.query.example.vo.SecondVO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class QConfigRepository{
  @Autowired
  private JPAQueryFactory jpaQueryFactory;

  public List<SecondVO> findByIdTuningSecond(Long infoId) {
    QInfoEntity info = new QInfoEntity("info");
    QConfigEntity config = new QConfigEntity("config");
    QDeliveryEntity delivery = new QDeliveryEntity("delivery");
    QDeliveryEntity whereDelivery = new QDeliveryEntity("whereDelivery");
    return jpaQueryFactory
      .select(
        Projections.constructor(
          SecondVO.class,
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
      .where(info.id.in(
        JPAExpressions
          .select(
            whereDelivery.configId
          )
          .from(whereDelivery)
          .where(whereDelivery.configId.eq(infoId))
      ))
      .orderBy(info.createdAt.desc())
      .fetch();
  }
  
}
