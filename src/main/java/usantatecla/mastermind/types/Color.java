package usantatecla.mastermind.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color {
	RED, 
	BLUE, 
	YELLOW, 
	GREEN, 
	ORANGE, 
	PURPLE,
	NULL;

	public static int length() {
		return Color.values().length;
	}

	public static List<Color> getAll() {
        List<Color> colors = new ArrayList<Color>(Arrays.asList(Color.values()));
        colors.remove(Color.NULL);
        return colors;
    }

    public boolean isNull(){
        return this == Color.NULL;
    }
}
