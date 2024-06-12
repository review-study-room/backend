package com.fudan.studyroom.controller;

import com.fudan.studyroom.entity.Seat;
import com.fudan.studyroom.service.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/api/seats")
@Controller
public class SeatController {

    @Resource
    private SeatService seatService;

    @RequestMapping(value = "{roomId}", method = RequestMethod.POST)
    @ResponseBody
    public void addSeat(
            @PathVariable("roomId")Integer roomId,
            @RequestParam("seat") Seat seat) {
        seatService.addSeat(roomId, seat);
    }

    @RequestMapping(value = "{roomId}/{seatId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSeat(
            @PathVariable("seatId")Integer seatId, @PathVariable String roomId) {
        seatService.deleteSeat(seatId);
    }


    @RequestMapping(value = "{roomId}/{seatId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateSeat(
            @PathVariable("seatId")Integer seatId,
            @RequestParam("seat") Seat seat) {
        seatService.updateSeat(seatId, seat);
    }

    @RequestMapping(value = "{roomId}/{seatId}", method = RequestMethod.GET)
    @ResponseBody
    public Seat getSeat(
            @PathVariable("seatId")Integer seatId) {
        return seatService.getSeat(seatId);
    }

    @RequestMapping(value = "{roomId}", method = RequestMethod.GET)
    @ResponseBody
    public void ReserveSeat(
            @PathVariable("roomId")Integer roomId,
            @RequestParam("seatId")Integer seatId,
            @RequestParam("userId")Integer userId,
            @RequestParam("startTime") Date startTime,
            @RequestParam("endTime")Date endTime) {
        seatService.ReserveSeat(roomId, seatId, userId, startTime, endTime);
    }


}
