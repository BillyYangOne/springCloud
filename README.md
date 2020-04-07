# springCloud —— samples
springcloud 相关


## 项目列表
1.  hello-world （springboot 示例）

2.  springcloud-weather （天气预报样例）

3.  micro-weather-basic 
    基础服务

4. micro-weather-redis
    使用redis对数据进行缓存

5.  micro-weather-quartz
    使用quartz定时服务对天气数据进行定时抽取

6.  micro-weather-report 
    集成thymeleaf模板对天气预报信息进行展示

## 微服务架构
     通过 DDD 对天气预报微服务进行拆分，整个系统划分为四个微服务：
     1）、天气数据采集微服务（包含数据采集和数据存储组件）
     2）、天气数据API微服务（天气数据查询组件）
     3）、城市数据API微服务（城市数据查询组件）
     4）、天气预报微服务 （数据展示组件）
     
1. msa-weather-collection-server 数据采集

2.  msa-weather-data-server 天气数据API

3.  msa-weather-city-server 城市数据API

4.  msa-weather-report-server 天气预报

