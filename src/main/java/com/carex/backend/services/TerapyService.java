package com.carex.backend.services;

import com.carex.backend.dto.TerapyDTO;
import com.carex.backend.entity.Terapy;
import com.carex.backend.enums.ImagesEnum;
import com.carex.backend.repository.TerapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TerapyService {

    @Autowired
    TerapyRepository terapyRepository;

    public List<Terapy> findAllTerapies() {
        return terapyRepository.findAll();
    }

    public List<String> findAllTerapyNames() {
        List<Terapy> terapyListFromDb = terapyRepository.findAll();
        return terapyListFromDb.stream().map(Terapy::getName).collect(Collectors.toList());
    }

    public List<String> findAllTerapyDescriptions() {
        List<Terapy> terapyListFromDb = terapyRepository.findAll();
        return terapyListFromDb.stream().map(Terapy::getDescription).collect(Collectors.toList());
    }

    public List<TerapyDTO> findAllTerapiesWithImagesBySize(String size) {
        
        List<Terapy> terapyListFromDb = terapyRepository.findAllTerapySortingIsAlternativeFirst();
        List<TerapyDTO> terapyDTOList = new ArrayList<>();

        Map<String, String> alternativeImagesMap = this.getAllAlternativeImagesBySize(size);
        Map<String, String> physioterapyImagesMap = this.getAllPhysioterapyImagesBySize(size);

        terapyListFromDb.forEach(terapy -> {
            if(terapy.isAlternative()) {
                TerapyDTO terapyDTO = new TerapyDTO();
                terapyDTO.setName(terapy.getName());
                terapyDTO.setDescription(terapy.getDescription());

                terapyDTO.setImage(alternativeImagesMap.get(terapy.getName()));
                terapyDTO.setIsAlternative(true);
                terapyDTOList.add(terapyDTO);
            }
        });

        terapyListFromDb.forEach(terapy -> {
            if(!terapy.isAlternative()) {
                TerapyDTO terapyDTO = new TerapyDTO();
                terapyDTO.setName(terapy.getName());
                terapyDTO.setDescription(terapy.getDescription());

                terapyDTO.setImage(physioterapyImagesMap.get(terapy.getName()));
                terapyDTO.setIsAlternative(false);
                terapyDTOList.add(terapyDTO);
            }
        });

            return terapyDTOList;
    }
    public Map<String, String> getAllAlternativeImagesBySize(String size) {
        Map<String, String> alternativeTerapyImagesMap = new HashMap<>();

        for(ImagesEnum image : ImagesEnum.values()) {
            if(image.isAlternative()) {
                if(size.equals("small")) {
                    alternativeTerapyImagesMap.put(image.getIdentifier(), image.getSmall());
                }
                if(size.equals("regular")) {
                    alternativeTerapyImagesMap.put(image.getIdentifier(), image.getRegular());
                }
                if(size.equals("big")) {
                    alternativeTerapyImagesMap.put(image.getIdentifier(), image.getBig());
                }
            }
        }
        return alternativeTerapyImagesMap;
    }

    public Map<String, String> getAllPhysioterapyImagesBySize(String size) {
        Map<String, String> physioterapyTerapyImagesMap = new HashMap<>();

        for(ImagesEnum image : ImagesEnum.values()) {
            if(!image.isAlternative()) {
                if(size.equals("small")) {
                    physioterapyTerapyImagesMap.put(image.getIdentifier(),image.getSmall());
                }
                if(size.equals("regular")) {
                    physioterapyTerapyImagesMap.put(image.getIdentifier(),image.getRegular());
                }
                if(size.equals("big")) {
                    physioterapyTerapyImagesMap.put(image.getIdentifier(),image.getBig());
                }
            }
        }
        return physioterapyTerapyImagesMap;
    }

}
