package com.example.demo4.controller;

import com.example.demo4.dao.IAnimalDao;
import com.example.demo4.dao.IPetDao;
import com.example.demo4.dto.AnimalDto;
import com.example.demo4.dto.PetDto;
import com.example.demo4.model.Animal;
import com.example.demo4.model.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/petAnimal")
public class PetAnimalController {
    private final ObjectMapper objectMapper;
    private final IAnimalDao iAnimalDao;
    private final IPetDao iPetDao;

    public PetAnimalController(ObjectMapper objectMapper, IAnimalDao iAnimalDao, IPetDao iPetDao) {
        this.objectMapper = objectMapper;
        this.iAnimalDao = iAnimalDao;
        this.iPetDao = iPetDao;
    }

    @ResponseBody
    @PostMapping("/createAnimal")
    public AnimalDto createAnimal(@RequestBody AnimalDto animalDto) {
        System.out.println("контроллер createAnimal");
        Animal animal = objectMapper.convertValue(animalDto, Animal.class);
        return objectMapper.convertValue(iAnimalDao.save(animal), AnimalDto.class);
    }

    @ResponseBody
    @PostMapping("/createPetThroughAnimal")
    public PetDto createPetThroughAnimal(@RequestBody PetDto petDto) {
        System.out.println("контроллер createPetThroughAnimal");
        Pet pet = objectMapper.convertValue(petDto, Pet.class);
        return objectMapper.convertValue(iAnimalDao.save(pet), PetDto.class);
    }

    @ResponseBody
    @PostMapping("/createPet")
    public PetDto createPet(@RequestBody PetDto petDto) {
        System.out.println("контроллер createPet");
        Pet pet = objectMapper.convertValue(petDto, Pet.class);
        return objectMapper.convertValue(iPetDao.save(pet), PetDto.class);
    }

    @ResponseBody
    @PostMapping("/createPetWithTime")
    public String createPetWithTime(@RequestBody PetDto petDto) {
        System.out.println("контроллер createPetWithTime");
        // Pet pet = objectMapper.convertValue(petDto, Pet.class);
        LocalDate dayDto = petDto.getDayFrom();
        System.out.println(dayDto);
//        while (dayDto.isBefore(petDto.getDayTo().plusDays(1))) {
//
//            iPetDao.save(Pet.builder()
//                    .age(petDto.getAge())
//                    .name(petDto.getName())
//                    .day(dayDto)
//                    .build());
//            dayDto = dayDto.plusDays(1);
//
//            System.out.println(dayDto);
//        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String[] dates = petDto.getPeriod().split("-");
        System.out.println(dates.length);
        List<LocalDate> collect =  Arrays.stream(dates).map(a -> LocalDate.parse(a,formatter)).collect(Collectors.toList());
        System.out.println(collect.get(0)+"   "+ collect.get(1));

        return "метод прошел";
    }

    @GetMapping("/read/all")
    public List<PetDto> readAll() {
        return iAnimalDao.findAll().stream()
                .map(pet -> objectMapper.convertValue(pet, PetDto.class))
                .collect(Collectors.toList());

    }

}
