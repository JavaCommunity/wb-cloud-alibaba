# wb-cloud-alibaba
## 前言
wb-cloud-alibaba致力与打造一个完整的基于spring cloud alibaba的企业级管理系统。

## 项目介绍
wb-cloud-alibaba基于spring cloud，spring cloud alibaba，mybatis实现。
采用docker容器化部署。

## 项目演示
TBD 

## 组织结构
~~~
wb-cloud-alibaba
    |──── doc -- 文档存储目录
    |──── wb-cloud-common -- 项目utils及基础代码
    |──── wb-cloud-gateway -- 网关中心
    |──── wb-module-components -- 公共组件
    |     ├──── wb-dynamic-datasource-component --  基于AbstractRoutingDataSource的动态数据源
    |     ├──── wb-knife4j-component --  knife4j组件
    |     ├──── wb-office-component -- office组件
    |     ├──── wb-oss-component -- oss组件
    |     └──── wb-quartz-component -- 基于quartz定时任务
    |──── wb-module-examples -- 样例
    |     ├──── wb-docker-example -- docker使用样例
    |     ├──── wb-dynamic-datasource-example -- 动态数据源样例
    |     ├──── wb-knife4j-example -- knife4j使用样例
    |     ├──── wb-nacos-example -- nacos使用样例
    |     ├──── wb-office-example -- office使用样例
    |     ├──── wb-oss-example -- oss使用样例
    |     ├──── wb-quartz-example -- quartz使用样例
    |     ├──── wb-seata-example -- seata使用样例
    |     |     ├──── wb-seata-order-service -- seata-order样例
    |     |     └──── wb-seata-storage-service -- seata-storeage样例
    |     ├──── wb-sso-example -- sso使用样例
    |     |     ├──── wb-sso1-example -- sso client1
    |     |     └──── wb-sso2-example -- sso client2
    |──── wb-module-oauth -- 基于oauth2的认证中心
    |     ├──── wb-core-oauth -- oauth核心代码
    |     └──── wb-service-oauth -- oauth提供者
    |──── wb-module-workflow -- 基于flowable工作流
~~~

## 技术选型
TBD

## 架构图
TBD

## 开发计划
~~~
√   1.wb-oss-component 对象存储组件
√   2.wb-dynamic-datasource-component 动态数据源,基于AbstractRoutingDataSource实现
√   3.wb-office-component 在线文档编辑,基于pageoffice实现
    4.wb-sentinel-example 限流样例
    5.wb-sentinel-datasource-component Sentinel数据源
√   6.wb-cloud-gateway 网关
√   7.wb-knife4j-component knife4j在线接口显示组件 
√   8.wb-docker-example docker打包使用样例
    9.wb-feign-example feign使用样例
    10.wb-ureport-component 在线报表组件
√   11.wb-quartz-component 定时任务组件
    12.wb-workflow-component 工作流组件，基于flowable实现
~~~




