package lpnu.mapper;

import lpnu.dto.TruckDTO;
import lpnu.entity.Truck;
import org.springframework.stereotype.Component;

@Component
public class TruckToTruckDTOMapper {
    public static TruckDTO toDTO(Truck truck)
    {
        TruckDTO truckDTO = new TruckDTO();
        truckDTO.setLiftingСapacity(truck.getLiftingСapacity());
        return truckDTO;
    }
}
