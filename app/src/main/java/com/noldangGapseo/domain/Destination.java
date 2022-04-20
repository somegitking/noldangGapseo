package com.noldangGapseo.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="destination")
public class Destination {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "destination_id")
  Integer destinationId;
  @Column(name = "user_id")
  Integer userId;

  //  String nickName;

  @Column(name = "destination_type_id")  
  Integer destinationTypeId;

  //  String destinationTypeName;
  @Column(name = "destination_name")  
  String destinationName;
  @Column(name = "contents")  
  String contents;
  @Column(name = "phone")  
  String phone;
  @Column(name = "latitude")  
  Float latitude;
  @Column(name = "longitude")  
  Float longitude;
  @Column(name = "address")  
  String address;
  //  Integer likesCnt;
  //  Integer commentsCnt;
  //  String thumbNailImg;
  @Column(name = "reg_date")  
  Date regDate;
  @Column(name = "update_date")  
  Date updateDate;
}
