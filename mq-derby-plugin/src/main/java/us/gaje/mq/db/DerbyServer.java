/**
 * Copyright (C) 2011 GAAOC-IT
 *
 * GAJE EFiling is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GAJE EFiling is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GAJE EFiling.  If not, see <http://www.gnu.org/licenses/>.
 */

package us.gaje.mq.db;

import java.io.PrintWriter;

import org.apache.derby.drda.NetworkServerControl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

public class DerbyServer implements InitializingBean{
	
	private Logger log = Logger.getLogger(DerbyServer.class);

	public void afterPropertiesSet() throws Exception {
		
		log.info("Loading mq-derby-plugin");
		log.info("Starting derby server");	
		
		final NetworkServerControl networkServerControl = new 
			NetworkServerControl();
				
		//this method forks into the background
		networkServerControl.start(new PrintWriter(System.out));					
	}

}
