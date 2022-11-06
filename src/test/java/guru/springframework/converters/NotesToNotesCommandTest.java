package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import org.junit.jupiter.api.Test;

import static guru.springframework.converters.testdata.TestData.ID;
import static guru.springframework.converters.testdata.TestData.NOTES;
import static guru.springframework.converters.testdata.TestData.RECIPE_NOTES;
import static org.assertj.core.api.Assertions.assertThat;

class NotesToNotesCommandTest {
  
  NotesToNotesCommand converter = new NotesToNotesCommand();
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenNotes_whenConvertInvoked_thenReturnNotesCommand() {
    assertThat(converter.convert(NOTES))
        .returns(ID, NotesCommand::getId)
        .returns(RECIPE_NOTES, NotesCommand::getRecipeNotes);
  }
  
}