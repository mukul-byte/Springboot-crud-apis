package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Timer;
import net.javaguides.springboot.repository.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TimerController {

    @Autowired
    private TimerRepository timerRepository;

    // get all timers
    @GetMapping("/timer")
    public List<Timer> getAllTimer(){
        return timerRepository.findAll();
    }

    // create timer rest api
    @PostMapping("/timer")
    public Timer createEmployee(@RequestBody Timer timer) {
        return timerRepository.save(timer);
    }

    // get timer by id rest api
    @GetMapping("/timer/{id}")
    public ResponseEntity<Timer> getTimerById(@PathVariable Long id) {
        Timer timer = timerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Timer not exist with id :" + id));
        return ResponseEntity.ok(timer);
    }

    // update timer rest api

    @PutMapping("/timer/{id}")
    public ResponseEntity<Timer> updateTimer(@PathVariable Long id, @RequestBody Timer timerDetails){
        Timer timer = timerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Timer not exist with id :" + id));

        timer.setName(timerDetails.getName());
        timer.setFlowName(timerDetails.getFlowName());
        timer.setDownTimeFrom(timerDetails.getDownTimeFrom());
        timer.setDownTimeTo(timerDetails.getDownTimeTo());

        Timer updatedTimer = timerRepository.save(timer);
        return ResponseEntity.ok(updatedTimer);
    }
    // delete timer rest api
    @DeleteMapping("/timer/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTimer(@PathVariable Long id){
        Timer timer = timerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Timer not exist with id :" + id));

        timerRepository.delete(timer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}