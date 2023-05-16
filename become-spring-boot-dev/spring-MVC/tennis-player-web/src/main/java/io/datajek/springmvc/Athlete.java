package io.datajek.springmvc;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Athlete {

    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;
    private String country;
    private String handedness;
    private String[] grandSlams;

    @NotNull(message = "This is a required field.")
    @Min(value = 1, message = "Value must be greater than or equal to 1.")
    @Max(value = 100, message = "Value must be less than or equal to 100.")
    private Integer rank;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Date must be in the past.")
    private Date lastWon;

    @Pattern(regexp = "^\\$([0-9]{1,3},([0-9]{3},)*[0-9]{3})$", message = "Incorrect format")
    private String prizeMoney;

    public void shout() {
        System.out.println("I am shouting!");
    }
}
