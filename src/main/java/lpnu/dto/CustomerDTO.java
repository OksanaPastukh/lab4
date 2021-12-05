package lpnu.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDTO {

    private String name;

    public CustomerDTO() {
    }

    public CustomerDTO(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
