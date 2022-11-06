package guru.springframework.converters;

import guru.springframework.domain.Notes;
import org.junit.jupiter.api.Test;

import static guru.springframework.converters.testdata.TestData.ID;
import static guru.springframework.converters.testdata.TestData.NOTES_COMMAND;
import static guru.springframework.converters.testdata.TestData.RECIPE_NOTES;
import static org.assertj.core.api.Assertions.assertThat;

class NotesCommandToNotesTest {
  
  NotesCommandToNotes converter = new NotesCommandToNotes();
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenNotesCommand_whenConvertInvoked_thenReturnNotes() {
    assertThat(converter.convert(NOTES_COMMAND))
        .returns(ID, Notes::getId)
        .returns(RECIPE_NOTES, Notes::getRecipeNotes);
  }
  
}