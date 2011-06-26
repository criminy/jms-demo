/**
 * Copyright (C) 2011 sheenobu
 *
 * JMS-Demo is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JMS-Demo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JMS-Demo.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sheenobu.consumer;

import org.apache.camel.builder.RouteBuilder;

public class DemoConsumer extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:demo")
			.id("net.sheenobu.demo.receiver")
			.log("Received Message: ${body}");				
	}
	
}
