// This file is part of MicropolisJ.
// Copyright (C) 2013 Jason Long
// Portions Copyright (C) 1989-2007 Electronic Arts Inc.
//
// MicropolisJ is free software; you can redistribute it and/or modify
// it under the terms of the GNU GPLv3, with additional terms.
// See the README file, included in this distribution, for details.

package micropolisj.engine;

import static micropolisj.engine.TileConstants.*;

class BuildingTool extends ToolStroke
{
	public BuildingTool(Micropolis engine, MicropolisTool tool, int xpos, int ypos)
	{
		super(engine, tool, xpos, ypos);
	}

	@Override
	public void dragTo(int xdest, int ydest)
	{
		this.xpos = xdest;
		this.ypos = ydest;
		this.xdest = xdest;
		this.ydest = ydest;
	}

	@Override
	boolean apply1(ToolEffectIfc eff)
	{
		switch (tool)
		{
		case FIRE:
			return applyZone(eff, FIRESTATION);

		case POLICE:
			return applyZone(eff, POLICESTATION);

		case POWERPLANT:
			return applyZone(eff, POWERPLANT);

		case STADIUM:
			return applyZone(eff, STADIUM);

		case SEAPORT:
			return applyZone(eff, PORT);

		case NUCLEAR:
			return applyZone(eff, NUCLEAR);

		case AIRPORT:
			return applyZone(eff, AIRPORT);
			
		case CLEANING_PARK:
			return applyZone(eff, CLEANING_PARK); //If the tile we're applying is the CLEANING_PARK, use applyZone to place a CLEANING_PARK tile
		
		case CLEANING_STATION:
			return applyZone(eff, CLEANING_STATION); //If the tile we're applying is the CLEANING_PARK, use applyZone to place a CLEANING_PARK tile
		default:
			// not expected
			throw new Error("unexpected tool: "+tool);
		}
	}
}
