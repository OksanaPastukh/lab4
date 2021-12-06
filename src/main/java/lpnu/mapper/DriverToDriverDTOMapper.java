package lpnu.mapper;

import lpnu.dto.CustomerDTO;
import lpnu.dto.DriverDTO;

import lpnu.entity.Driver;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DriverToDriverDTOMapper {
    public static DriverDTO toDTO(Driver driver)
    {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driver.getId());
        driverDTO.setName(driver.getName());
        driverDTO.setSurname(driver.getSurname());
        driverDTO.setPhoneNumber(driver.getPhoneNumber());
        return driverDTO;

    }
}
