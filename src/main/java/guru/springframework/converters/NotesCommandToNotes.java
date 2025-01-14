package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.springframework.core.convert.converter.Converter;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
  @Override
  public Notes convert(NotesCommand source) {
    if (source == null) return null;
    
    Notes notes = new Notes();
    notes.setId(source.getId());
    notes.setRecipeNotes(source.getRecipeNotes());
    return notes;
  }
}
