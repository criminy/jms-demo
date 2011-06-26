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

package us.gaje.mq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.InitializingBean;

/**
 * Route configuration for setting up a listener that 
 * waits for status inputs and returns back a simple, valid body.
 * 
 */
public class StatusListener extends RouteBuilder implements InitializingBean{

	public void afterPropertiesSet() throws Exception {
		log.info("Loaded md-control-plugin:status-listener");		
	}

	@Override
	public void configure() throws Exception {
		from("jms:" + Status.queueName)
			.inOut()
			.setBody().simple("yes");
	}
}
