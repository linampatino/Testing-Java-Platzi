package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import play.Player;
import play.Dice;

public class PlayerTest {

	@Test
	public void losses_when_dice_number_is_too_low() {
		Dice dice = Mockito.mock(Dice.class);
		
		/*Simula el dado, por lo que cuando llamen a la clase Dice.roll,
		  se ejecutará lo que se define en el mockito(linea 18), de esta forma
		  se establece un valor por defecto para poder probar */
		Mockito.when(dice.roll()).thenReturn(2);
		
		
		Player player = new Player(dice, 2);
		assertEquals(false, player.play());
	}
	
	@Test
	public void wins_when_dice_number_is_big() {
		Dice dice = Mockito.mock(Dice.class);
		
		/*Simula el dado, por lo que cuando llamen a la clase Dice.roll,
		  se ejecutará lo que se define en el mockito(linea 18), de esta forma
		  se establece un valor por defecto para poder probar */
		Mockito.when(dice.roll()).thenReturn(4);
		
		
		Player player = new Player(dice, 3);
		assertEquals(false, player.play());
	}
}
