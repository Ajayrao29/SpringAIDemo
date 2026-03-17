package org.example.springaionboardingservice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeanVerifier implements ApplicationRunner {

    private final ChatModel chatModel;
    private final ChatClient.Builder chatClientBuilder;
    private final ApplicationContext applicationContext;

    public BeanVerifier(ChatModel chatModel,
                        ChatClient.Builder chatClientBuilder,
                        ApplicationContext applicationContext) {
        this.chatModel = chatModel;
        this.chatClientBuilder = chatClientBuilder;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("=================================");
        System.out.println("✅ ChatModel bean   : " + chatModel.getClass().getName());
        System.out.println("✅ ChatClient.Builder: " + chatClientBuilder.getClass().getName());
        System.out.println("=================================");

        // List all Spring AI beans
        String[] allBeans = applicationContext.getBeanDefinitionNames();
        System.out.println("--- Spring AI Beans ---");
        Arrays.stream(allBeans)
                .filter(bean -> bean.toLowerCase().contains("openai")
                        || bean.toLowerCase().contains("chat")
                        || bean.toLowerCase().contains("ai"))
                .forEach(System.out::println);
        System.out.println("=================================");
    }
}