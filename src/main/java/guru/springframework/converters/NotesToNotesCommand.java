package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.springframework.core.convert.converter.Converter;

public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
  @Override
  public NotesCommand convert(Notes source) {
    if (source == null) return null;
    
    NotesCommand notes = new NotesCommand();
    notes.setId(source.getId());
    notes.setRecipeNotes(source.getRecipeNotes());
    
    return notes;
  }
}
