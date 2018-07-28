package com.merchants.guide.to.galaxy.roman.units;

import java.util.ArrayList;
import java.util.List;

import com.merchants.guide.to.galaxy.roman.units.hundred.HundredUnitInterpreter;
import com.merchants.guide.to.galaxy.roman.units.ten.TenUnitInterpreter;
import com.merchants.guide.to.galaxy.roman.units.thousand.ThousandUnitInterpreter;
import com.merchants.guide.to.galaxy.roman.units.unit.UnitsUnitInterpreter;

public enum BuildUnitInterpreterQueue {
	INSTANCE;
	
	public List<UnitInterpreter> buildUnitInterpreterQueue() {
		List<UnitInterpreter> interPreterQueue = new ArrayList<UnitInterpreter>();
		interPreterQueue.add(new ThousandUnitInterpreter());
		interPreterQueue.add(new HundredUnitInterpreter());
		interPreterQueue.add(new TenUnitInterpreter());
		interPreterQueue.add(new UnitsUnitInterpreter());
		return interPreterQueue;
	}
}
