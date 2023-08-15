package com.example.demo.dto;
        import com.fasterxml.jackson.annotation.JsonFormat;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String first_name;
    private String last_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
