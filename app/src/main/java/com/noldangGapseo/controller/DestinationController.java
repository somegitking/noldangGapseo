package com.noldangGapseo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.noldangGapseo.domain.Destination;
import com.noldangGapseo.domain.DestinationResponse;
import com.noldangGapseo.service.DestinationService;

@RequestMapping("/destination")
@RestController
public class DestinationController {

  @Autowired
  DestinationService service;

  //놀당갑서의 여행지를 모두 가져온다. 
  @GetMapping("/admin/list")
  List<Destination> getAdminDesList() {
    return service.getAdminDesList();
  }

  //유저들이 작성한 여행지 리스트를 가져온다.
  @GetMapping("/users/list")
  List<Destination> getUsersDesList() {
    return service.getUsersDesList();
  }

  // 여행지 하나를 가져온다.
  // type : 놀당 여행지 = N , 유저 여행지 = U
  @GetMapping("/getDes")
  DestinationResponse getDes(@RequestParam Integer desId, @RequestParam String type) {
    return service.getDes(desId, type);
  }

  // 유저의 새로운 여행지 리스트를 가져온다.
  @GetMapping("/user/list")
  List<Destination> getUserDesList(@RequestParam Integer userId) {return service.getUserDesList(userId);}

  // 좋아요 추가
  @PostMapping("/addLike")
  Integer addLike(Integer desId, Integer userId){
    return service.addLike(desId, userId);
  }

  // 좋아요 삭제
  @DeleteMapping("/deleteLike")
  Integer deleteLike(Integer desId, Integer userId){
    return service.deleteLike(desId, userId);
  }

  @GetMapping("/admin/list1")
  public String destinationlist(Model model, @PageableDefault(page =0, size=8, sort="destinationId", direction = Sort.Direction.DESC)Pageable pageable){
    //sort는 Destination.java의 프로퍼티 중 1개 선택해야 하는 듯

    System.out.println("-----------------------------------------------------------");

    Page<Destination> list = service.getAdminDesList1(pageable);
    int nowPage = list.getPageable().getPageNumber() + 1;
    int startPage = Math.max(nowPage-4, 1);
    int endPage = Math.min(nowPage +5, list.getTotalPages());
    model.addAttribute("list", list);
    model.addAttribute("nowPage", nowPage);
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);



    return "destinationlist";
  }

}
