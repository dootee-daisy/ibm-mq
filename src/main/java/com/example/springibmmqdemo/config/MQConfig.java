package com.example.springibmmqdemo.config;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import javax.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class MQConfig {

    @Bean
    public ConnectionFactory connectionFactory() throws Exception {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(1414);
        factory.setQueueManager("QM1");
        factory.setChannel("DEV.APP.SVRCONN");
        factory.setTransportType(1);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
}