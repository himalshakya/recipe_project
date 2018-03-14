package net.shakya.himal.recipe_project.converters;

import lombok.Synchronized;
import net.shakya.himal.recipe_project.commands.CategoryCommand;
import net.shakya.himal.recipe_project.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Nullable
    @Synchronized
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null){
            return null;
        }

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setName(source.getName());

        return categoryCommand;
    }
}
