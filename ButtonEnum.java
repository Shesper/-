package com.casillas.balgoon;

public enum ButtonEnum {

	DARK_BUTTON(0),
	MONOL_BUTTON(1),
	RESULT_MONOL_BUTTON(2);
	
	private int id;
	
	ButtonEnum(int index)
	{
		id = index;
	}
	
	public int getID()
	{
		return id;
	}
}
