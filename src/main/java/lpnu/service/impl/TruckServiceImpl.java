package lpnu.service.impl;

import lpnu.dto.NewTruckDTO;
import lpnu.dto.TruckDTO;
import lpnu.entity.Car;
import lpnu.entity.Truck;
import lpnu.mapper.CarToCarDTOMapper;
import lpnu.mapper.TruckToTruckDTOMapper;
import lpnu.repository.CarRepository;
import lpnu.repository.TruckRepository;
import lpnu.service.TruckService;
import org.springframework.stereotype.Service;

@Service
public class TruckServiceImpl implements TruckService {

    @Override
    public TruckDTO createTruck(NewTruckDTO newTruckDTO) {
        Truck truck = TruckRepository.createTruck(newTruckDTO);
        return TruckToTruckDTOMapper.toDTO(truck);
    }
}
