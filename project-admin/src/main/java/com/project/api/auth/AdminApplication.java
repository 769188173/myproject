package com.project.api.auth;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 显示健康状况
 * 显示应用运行时的详细信息，如：JVM 和内存指标等
 * 计数器和测量指标
 * 数据源度量
 * 缓存度量
 * 跟踪和下载日志文件
 * 查看 jvm 系统和环境属性
 * 一键管理loglevel
 * 管理执行 JMX-beans
 * 查看线程转储
 * 查看跟踪信息
 * Hystrix-Dashboard集成（2.X版本已删除集成）
 * 下载 heapdump
 * 状态更改通知（支持：电子邮件、Slack、Hipchat等）
 * 状态更改事件日志（非永久性）
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
@EnableFeignClients
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }




}

