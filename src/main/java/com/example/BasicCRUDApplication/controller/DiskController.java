package com.example.BasicCRUDApplication.controller;

import com.example.BasicCRUDApplication.model.Disk;
import com.example.BasicCRUDApplication.service.DiskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disks")
public class DiskController {
    private final DiskService diskService;

    public DiskController(DiskService diskService) {
        this.diskService = diskService;
    }

    @GetMapping("")
    public List<Disk> getAllDisks(){
        return diskService.getAllDisks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disk> getDiskById(@PathVariable Long id){
        Optional<Disk> diskOptional = diskService.getDiskById(id);
        return diskOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Disk> createDisk(@RequestBody Disk disk){
        Disk createDisk = diskService.createDisk(disk);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDisk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disk> updateDisk(@PathVariable Long id, @RequestBody Disk disk){
        Disk updatedDisk = diskService.updateDisk(id, disk);
        if (updatedDisk != null){
            return ResponseEntity.ok(updatedDisk);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisk(@PathVariable Long id){
        diskService.deleteDisk(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllDisks(){
        diskService.deleteAllDisks();
        return ResponseEntity.noContent().build();
    }
}
