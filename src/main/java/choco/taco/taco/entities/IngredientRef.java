package choco.taco.taco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
public class IngredientRef {

    private final String ingredient;

    public IngredientRef(String ingredient) {
        this.ingredient = ingredient;
    }

}
