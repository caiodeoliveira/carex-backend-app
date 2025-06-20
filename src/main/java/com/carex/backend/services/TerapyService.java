package com.carex.backend.services;

import com.carex.backend.dto.TerapyDTO;
import com.carex.backend.entity.Terapy;
import com.carex.backend.enums.ImagesEnum;
import com.carex.backend.repository.TerapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<String> findAllTerapyDescriptions() {
        return terapyRepository.findAllTerapyDescriptions();
    }

    public List<TerapyDTO> findAllTerapiesWithImagesBySize(String size) {
        List<Terapy> terapyListFromDb = terapyRepository.findAllTerapySortingIsAlternativeFirst();
        Map<String, String> alternativeImagesMap = getImagesBySizeAndType(size, true);
        Map<String, String> physioterapyImagesMap = getImagesBySizeAndType(size, false);

        return terapyListFromDb.stream()
                .map(terapy -> {
                    TerapyDTO dto = new TerapyDTO();
                    dto.setName(terapy.getName());
                    dto.setDescription(terapy.getDescription());
                    dto.setIsAlternative(terapy.isAlternative());
                    dto.setImage(terapy.isAlternative()
                            ? alternativeImagesMap.get(terapy.getName())
                            : physioterapyImagesMap.get(terapy.getName()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Map<String, String> getImagesBySizeAndType(String size, boolean isAlternative) {
        Map<String, String> imageMap = new HashMap<>();

        for (ImagesEnum image : ImagesEnum.values()) {
            if (image.isAlternative() == isAlternative) {
                switch (size) {
                    case "small":
                        imageMap.put(image.getIdentifier(), image.getSmall());
                        break;
                    case "regular":
                        imageMap.put(image.getIdentifier(), image.getRegular());
                        break;
                    case "big":
                        imageMap.put(image.getIdentifier(), image.getBig());
                        break;
                    default:
                        break;
                }
            }
        }

        return imageMap;
    }

}
