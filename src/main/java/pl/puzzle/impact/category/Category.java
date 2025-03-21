package pl.puzzle.impact.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@NoArgsConstructor(access = PRIVATE, force = true)
public class Category {

    @Column(name = "category")
    String value;

    private Category(String value) {
        this.value = value;
    }

    public static Category valueOf(CategoryType categoryType) {
        return new Category(categoryType.toString());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(value, category.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
