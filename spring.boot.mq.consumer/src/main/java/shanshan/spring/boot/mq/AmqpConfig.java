package shanshan.spring.boot.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shanshan.spring.boot.mq.common.constant.ExchangeConstant;
import shanshan.spring.boot.mq.constant.QueuesConstant;

//@EnableRabbit
//@Configuration
public class AmqpConfig {
	
//	@Bean
//    public Queue userInfoQueue() {
//        return new Queue(QueuesConstant.USER_ADD_QUEUE); //队列持久
//    }
//	
//	/**  
//     * 针对消费者配置  
//     * 1. 设置交换机类型  
//     * 2. 将队列绑定到交换机  
//     *   
//     *   
//        FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念  
//        HeadersExchange ：通过添加属性key-value匹配  
//        DirectExchange:按照routingkey分发到指定队列  
//        TopicExchange:多关键字匹配  
//     */  
//    @Bean  
//    public TopicExchange userExchange() {  
//        return new TopicExchange(ExchangeConstant.USER_EXCHANGE_KEY);  
//    }
//	
//	@Bean  
//    public Binding binding() {  
//        return BindingBuilder.bind(userInfoQueue()).to(userExchange()).with(ExchangeConstant.USER_ROUTING_KEY);  
//    } 	
}
