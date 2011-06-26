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

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
 

/**
 * Command line client which shuts down
 * a remote ActiveMQ system by sending
 * a specially crafted JMS message.
 * 
 * @author artripa
 *
 */
public class Shutdown 
{
	public static String brokerURL = "tcp://localhost:61616";
	
	public static final String queueName="jms.demo.mq.shutdown";
	
    public static void main( String[] args ) throws Exception
    {
    	CamelContext camelContext = new DefaultCamelContext();
    	ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
    	camelContext.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(factory));     	    	   
    	camelContext.start();
    	camelContext.createProducerTemplate().sendBody("jms:" + queueName,"shutdown");
    	//TODO: don't know if we should stop here, since sendBody is asynchronous.
    }
    
}
