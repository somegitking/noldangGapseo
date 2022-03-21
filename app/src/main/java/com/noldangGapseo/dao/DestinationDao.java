package com.noldangGapseo.dao;

import com.noldangGapseo.domain.Destination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DestinationDao {

 List<Destination> getUserDesList();

 List<Destination> getAdminDesList();

 Destination getUserDesOne(Integer desId);

}