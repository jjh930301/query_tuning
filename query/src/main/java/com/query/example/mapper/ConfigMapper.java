package com.query.example.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.query.example.vo.SecondVO;

@Mapper
public interface ConfigMapper {
  List<SecondVO> findByIdBeforeSecond(Long configId);
}
