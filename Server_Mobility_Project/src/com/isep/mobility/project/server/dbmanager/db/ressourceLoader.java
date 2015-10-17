

package com.isep.mobility.project.server.dbmanager.db;

import java.io.InputStream;

final public class ressourceLoader {
	public static InputStream Load(String path )
	{
		InputStream input = ressourceLoader.class.getResourceAsStream(path);
		if (input == null)
		{
			input = ressourceLoader.class.getResourceAsStream("/"+path);
		}
		return input;
	}

}
