package net.shakya.himal.recipe_project.converters;

import lombok.Synchronized;
import net.shakya.himal.recipe_project.commands.NotesCommand;
import net.shakya.himal.recipe_project.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Nullable
    @Synchronized
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null){
            return null;
        }

        Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());

        return notes;
    }
}
