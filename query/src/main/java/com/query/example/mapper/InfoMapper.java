package com.query.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.query.example.vo.FirstVO;

@Mapper
public interface InfoMapper {
  List<FirstVO> findByInfoidTuningFirst(Integer infoId);
}
