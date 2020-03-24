package com.springboot.demo10elasticsearch.config;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration("myElasticSearchConfig")
public class ElasticSearchConfig {
    // private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchConfig.class);
    @Value("${myElasticSearchConfig.ip}")
    private String hostName;
    /**
     * 端口
     */
    @Value("${myElasticSearchConfig.port}")
    private String port;
    /**
     * 集群名称
     */
    @Value("${myElasticSearchConfig.cluster-name}")
    private String clusterName;
    /**
     * 连接池
     */
    @Value("${myElasticSearchConfig.pool}")
    private String poolSize;
    /**
     * 嗅探开关
     */
    @Value("${myElasticSearchConfig.sniff}")
    private boolean sniff;

    /**
     * Bean name default  函数名字     * @return
     */
    @Bean(name = "transportClient")
    public TransportClient transportClient() {
        //LOGGER.info("Elasticsearch初始化开始。。。。。");
        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder().put("cluster.name", clusterName)
                    //集群名字
                    .put("client.transport.sniff", sniff)
                    //增加嗅探机制，找到ES集群
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))
                    //增加线程池个数，暂时设为5
                    .build();
            //配置信息Settings自定义
            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port));
            transportClient.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            //LOGGER.error("elasticsearch TransportClient create error!!", e);
        }
        return transportClient;
    }

}




