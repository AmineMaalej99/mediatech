package tn.iit.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    @NotNull(message = "Le nom est obligatoire !!")
    @Size(min = 5, max = 20, message = "le nombre de caractère doit être compris entre 5 et 20 ")
    private String nom;

    @NotNull(message = "Le prénom est obligatoire !!")
    @Size(min = 5, max = 20, message = "le nombre de caractère doit être compris entre 5 et 20 ")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^\\+216\\d{8}$\n",message = "format invalid")
    private String telephone;

}
