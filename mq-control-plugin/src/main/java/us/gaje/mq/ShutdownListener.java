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

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.BrokerServiceAware;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The JMS endpoint configuration for an endpoint
 * which shuts down the JVM, useful for shutting down
 * testing activemq servers invoked as background processes.
 * 
 * @author artripa
 *
 */
public class ShutdownListener extends RouteBuilder implements BrokerServiceAware, InitializingBean{

	private Logger log = Logger.getLogger(ShutdownListener.class);

	@Autowired
	BrokerService brokerService;
	
	@Override
	public void configure() throws Exception {
		from("jms:" + Shutdown.queueName)
			.process(new Processor() {				
				public void process(Exchange arg0) throws Exception {
					if(log.isInfoEnabled())
					{
						//TODO: show which IP/client sent it.
						log.info(String.format("Shutdown received"));							
					}
										
					//	This call probably 
					//	crashes the other camel consumers within the same JVM. 
					//  It's not an important issue it just prints
					//  a bunch of garbage.
					brokerService.stop();	
						
					//assumption: running within an environment that can handle System.exit?
					// TODO:
					//	How else do you tell a maven plugin to exit
					//	from within the invocation?
					// TODO: check for maven or OSGI or et-al?
					System.exit(0);
				}
			});
	}
	
	
	
	public void setBrokerService(BrokerService brokerService) {
		this.brokerService = brokerService;
	}
	
	public void afterPropertiesSet() throws Exception {
		log.info("Loaded md-control-plugin:shutdown-listener");
		log.warn("This plugin is for testing only! Should not be enabled in a production system!");
	}

}
