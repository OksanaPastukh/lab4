package lpnu.repository;

import lpnu.entity.Driver;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DriverRepository {
    private static Map<Long, Driver> drivers = new HashMap<Long,Driver>();
    //private static String filename = "drivers.dat";

    @PostConstruct
    public static void init()
    {
        drivers = new HashMap<Long,Driver>();
        Driver drive1 = new Driver("one","surname_one",123);
        drivers.put(drive1.getId(),drive1);
        Driver drive2 = new Driver("two","surname_two",456);
        drivers.put(drive2.getId(),drive2);
    }


    public static long getNewId()
    {
        long id = drivers.keySet().stream()
                .mapToLong(v->v)
                .max()
                .orElse(0) + 1;
        return id ;
    }
    public static List<Driver> getAllCustomers(){
        return drivers.values().stream().collect(Collectors.toList());
    }

}
