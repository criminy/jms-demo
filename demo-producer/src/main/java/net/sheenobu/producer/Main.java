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

package net.sheenobu.producer;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.timer.TimerComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ConnectionFactory fact = new ActiveMQConnectionFactory("tcp://localhost:61616");
		CamelContext ctx = new DefaultCamelContext();
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(fact));
		ctx.addComponent("timer",new TimerComponent());
		ctx.addRoutes(new DemoProducer());		
		ctx.start();
		while(true) {
			
		}
	}

}
