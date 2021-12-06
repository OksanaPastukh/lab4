package lpnu.service.impl;


import lpnu.dto.DriverDTO;
import lpnu.mapper.DriverToDriverDTOMapper;
import lpnu.repository.DriverRepository;
import lpnu.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    @Override
    public List<DriverDTO> getAllDrivers() {
        return DriverRepository.getAllCustomers().stream()
                .map(e -> DriverToDriverDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }
}
