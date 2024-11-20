package com.youcode.citronix.Services.Implementation;

import com.youcode.citronix.DTO.Field.FieldCreationDTO;
import com.youcode.citronix.DTO.Field.FieldDTO;
import com.youcode.citronix.DTO.Field.FieldOnlyDTO;
import com.youcode.citronix.Helpers.FieldValidation;
import com.youcode.citronix.Mappers.FieldMapper;
import com.youcode.citronix.Models.Entities.Farm;
import com.youcode.citronix.Models.Entities.Field;
import com.youcode.citronix.Repositories.FarmRepository;
import com.youcode.citronix.Repositories.FieldRepository;
import com.youcode.citronix.Services.Interfaces.FieldSIN;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class FieldSIM implements FieldSIN {

    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;
    private final FarmRepository farmRepository;

    @Override
    @Transactional
    public FieldCreationDTO createField(FieldCreationDTO fieldCreationDTO) {
        Farm farm = farmRepository.findById(fieldCreationDTO.getFarmId())
                .orElseThrow(() -> new EntityNotFoundException("Farm with ID " + fieldCreationDTO.getFarmId() + " not found"));

        FieldValidation.validateFieldConstraints(farm, fieldCreationDTO.getSurface());

        Field field = fieldMapper.toField(fieldCreationDTO);
        field.setFarm(farm);
        return fieldMapper.toFieldCreationDTO(fieldRepository.save(field));
    }


    @Override
    public List<FieldOnlyDTO> getFields() {
        List<Field> fields = fieldRepository.findAll();
        return fields.stream().map(fieldMapper::toFieldOnlyDTO).toList();
    }

    @Override
    public FieldDTO getField(UUID id) {
        if (fieldRepository.existsById(id)) {
            return fieldMapper.toFieldDTO(fieldRepository.findById(id).get());
        }else {
            throw new EntityNotFoundException("Field not found");
        }
    }

    @Override
    public Boolean deleteField(UUID id) {
        Field feild = fieldRepository.findById(id).orElse(null);
        if (feild != null) {
            fieldRepository.delete(feild);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public FieldCreationDTO updateField(UUID id, FieldCreationDTO fieldCreationDTO) {
        Field existingField = fieldRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Field with ID " + id + " not found"));

        Farm farm = farmRepository.findById(fieldCreationDTO.getFarmId())
                .orElseThrow(() -> new EntityNotFoundException("Farm with ID " + fieldCreationDTO.getFarmId() + " not found"));

        FieldValidation.validateFieldConstraints(farm, fieldCreationDTO.getSurface());

        existingField.setSurface(fieldCreationDTO.getSurface());
        existingField.setFarm(farm);

        return fieldMapper.toFieldCreationDTO(fieldRepository.save(existingField));
    }

}
