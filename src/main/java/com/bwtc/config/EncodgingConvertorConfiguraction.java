package com.bwtc.config;

import com.bwtc.Convertor.Encodingconvertor;
import com.bwtc.Convertor.GBKEncodingConvertor;
import com.bwtc.Convertor.UTF8EncodingConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 15:53 2018/5/26
 **/
@Configuration
public class EncodgingConvertorConfiguraction {

    @Bean
    public Encodingconvertor createUTF8Encodingconvertor(){
        return new UTF8EncodingConvertor();
    }

    @Bean
    public Encodingconvertor createGBKEncodingconvertor(){
        return new GBKEncodingConvertor();
    }
}
