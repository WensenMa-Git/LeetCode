### How to design a system

The common strategy to design a system, especially a web application, we can first design the high performance scalable architecture, and then come up with the detail functions.

For the architecture, (traditional, not aws):
We must say that the architecture will evolve as time grows. But it’s not necessary to have all these features as startup.

- [Split tiers] Initially, when the application is quite small, we run application server (web server and backend servier), database server and store the static files in one host. Application generally have three tiers (rest, service, data)
- [Split Server] To improve the performance, separate the application with database. We can use three host: application server, storage server, database server.
- [IO-Cache] To improve the I/O performance, we can use cache such as Redis, Hazelcast. The database access pressure could be relieved.
- [IO-Cache] To improve the internet response speed, we can use CDN (AWS cloudfront) for caching static files.
- [IO] To improve the I/O performance even more, we can split the read and write for the database. The primary database takes the responsibility for writing data and syncing the data to the secondary database. The secondary database took the responsibility for reading data. (Segregate our read traffic from write traffic)
- [IO] Index the database table.
- [asynchronize] If the request need more time to proceed, we can use asynchronized queue to improve the respond speed. Such as Amazon MQ, Amazon SNS, Amazon SQS.
- [cluster] To improve the computing performance, wen can create a cluster of db/file server. (AWS S3, AWS DB)
- [cluster] To improve the computing perfornace, we can create a cluster of application server. 
- [distributed] We can split the business model to micro-services.
- We can consider Nosql such as Dynamo DB, Elastic Search. (Consider AWS)
- Improve the security, maintenance. (Monitor)

### System Design Questions Example as following:
1. Amazon Locker
2. eCommerce Website
3. Youtube
4. News Feed System
