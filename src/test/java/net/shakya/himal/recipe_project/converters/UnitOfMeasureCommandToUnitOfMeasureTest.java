package net.shakya.himal.recipe_project.converters;

import net.shakya.himal.recipe_project.commands.UnitOfMeasureCommand;
import net.shakya.himal.recipe_project.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public final String DESCRIPTION = "description";
    public final long LONG_VALUE = new Long(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp(){
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullParameter(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        // when
        UnitOfMeasure uom = converter.convert(command);

        // then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}