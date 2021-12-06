package lpnu.service;


import lpnu.dto.CustomerDTO;
import lpnu.dto.DriverDTO;

import lpnu.dto.NewCustomerDTO;
import lpnu.dto.NewDriverDTO;

import java.util.List;

public interface DriverService {
    List<DriverDTO> getAllDrivers();
    DriverDTO createDriver(NewDriverDTO newDriverDTO);
    DriverDTO updateDriver(DriverDTO driverDTO);
    DriverDTO getDriverById(long id);
}
