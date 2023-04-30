package com.example.BasicCRUDApplication.service;

import com.example.BasicCRUDApplication.model.Disk;
import com.example.BasicCRUDApplication.repository.DiskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiskService {
    private final DiskRepository diskRepository;

    public DiskService(DiskRepository diskRepository) {
        this.diskRepository = diskRepository;
    }

    public List<Disk> getAllDisks(){
        return diskRepository.findAll();
    }

    public Optional<Disk> getDiskById(Long id){
        return diskRepository.findById(id);
    }

    public Disk createDisk(Disk disk){
        return diskRepository.save(disk);
    }

    public Disk updateDisk(Long id, Disk disk){
        Optional<Disk> diskOptional = diskRepository.findById(id);
        if(diskOptional.isPresent()){
            Disk existingDisk = diskOptional.get();
            existingDisk.setName(disk.getName());
            existingDisk.setDescription(disk.getDescription());
            existingDisk.setGenre(disk.getGenre());
            existingDisk.setRating(disk.getRating());
            existingDisk.setDirectors(disk.getDirectors());
            existingDisk.setCover(disk.getCover());
            return diskRepository.save(existingDisk);
        }else{
            return null;
        }
    }

    public void deleteDisk(Long id){
        diskRepository.deleteById(id);
    }

    public void deleteAllDisks(){
        diskRepository.deleteAll();
    }
}
