# jms-demo

JMS demo project; using activemq, camel, spring.

There are two primary systems here: 'mq' and 'demo'.

'mq' is a message queue testing environment forked from the gaje efiling prototype system on 2011-June-25.

'demo' is the group of demos written with JMS using 'mq' for its testing environment.

# Building #

Requires maven2 or 3 to build.

Run:

    $ mvn clean install

# Running #

Running requires 'ant'.

To run the message queue, use:

    $ ant run-mq

To run the individual demo applications, use:

    $ ant run-demo-1

for demo-1,

    $ ant run-demo-2 

for demo-2,.

# Technologies used #

This demo is showing off the following libraries and technologies:

 * Maven
  * maven-license plugin with multiple license files
  * multi-module projects with differing configurations.
  * simplifying maven commands with ant exec
 * JMS
  * ActiveMQ for the message broker
  * Camel for the JMS/business integration code.
 * Spring 
  * For DI, web, security.
    